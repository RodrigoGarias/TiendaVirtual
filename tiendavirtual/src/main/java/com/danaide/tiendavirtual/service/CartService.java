package com.danaide.tiendavirtual.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danaide.tiendavirtual.dto.CartBasicDetailsDTO;
import com.danaide.tiendavirtual.dto.CartDetailDTO;
import com.danaide.tiendavirtual.dto.CartProductDTO;
import com.danaide.tiendavirtual.enums.CartStatus;
import com.danaide.tiendavirtual.enums.CartType;
import com.danaide.tiendavirtual.jobs.CartJob;
import com.danaide.tiendavirtual.model.Cart;
import com.danaide.tiendavirtual.model.CartProducts;
import com.danaide.tiendavirtual.model.Client;
import com.danaide.tiendavirtual.model.Product;
import com.danaide.tiendavirtual.repository.CartProductRepo;
import com.danaide.tiendavirtual.repository.CartRepo;
import com.danaide.tiendavirtual.repository.ClientRepo;
import com.danaide.tiendavirtual.repository.ProductRepo;
import com.danaide.tiendavirtual.repository.PromotionDateRepo;

import jakarta.validation.constraints.NotNull;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CartService {
	
	private static final Logger logger = LoggerFactory.getLogger( CartService.class.getName() );
	
	private @Autowired ProductRepo productRepo;
	
	private @Autowired CartRepo cartRepo;
	
	private @Autowired ClientRepo clientRepo;

	private @Autowired CartProductRepo cartProdutRepo;
	
	private @Autowired PromotionDateRepo promotionDateRepo;
	
	private @Autowired ModelMapper modelMapper;
	
	
	
	@Value("${porcentage.descuento.promocion:0}")
	private int  descuentoPromocion;

	@Value("${cantidad.productos.para.descuento}")
	private Integer cantidadDeProductosParaDescuento;
	
	@Value("${descuento.cantidad.productos:0}")
	private int descuentoPorCantidadProductos;
	
	
	
	
	/**
	 * Metodo que crea una Cart nueva siempre cuando no haya una activa. En caso de que alguna este activa , se devuelve el oid de esa.
	 * @return
	 * @throws Exception 
	 */
	@Transactional( rollbackFor = Exception.class )
	public String createCart( @NotNull String clientOid ) throws Exception {
		try {
			Client client = this.clientRepo.findById( clientOid ).orElseThrow( ()-> new RuntimeException("No existe ningun cliente con oid " + clientOid ));
			Cart cart = this.clientRepo.findClientActiveCart( clientOid ).orElse(null);
					
			if( cart == null ) {
				Boolean isPromotionDate = this.promotionDateRepo.isPromotionDate( new Date() ) == 0 ? false : true ;
				cart = new Cart();
				cart.setCartType( isPromotionDate ? CartType.PROMOTION : CartType.NORMAL );
				String cartOid = this.cartRepo.save(cart).getOid();
				client.getCart().add( cart );
				this.clientRepo.save( client );
				return cartOid;
			}
			return cart.getOid();	
		} catch (Exception e) {
			throw new Exception("Error while creating the Cart." , e);
		}
	}
		
	
	
	
	@Transactional( rollbackFor = Exception.class )
	public String addProductToCart( @NotNull String productOid, @NotNull String cartOid , @NotNull int cantidad ) throws Exception {
		try {
			Cart cart = this.cartRepo.findById( cartOid ).orElseThrow( ()-> new RuntimeException("No existe ninguna carta con el oid " + cartOid ) );
			Product product = this.productRepo.findById( productOid ).orElseThrow(()-> new RuntimeException("No existe ningun producto con el oid " + productOid ) );
			CartProducts cartProduct = new CartProducts();
			cartProduct.setCart( cart );
			cartProduct.setProduct( product );
			cartProduct.setCantidadProducto( cantidad );
			return this.cartProdutRepo.save( cartProduct ).getOid();
		} catch (Exception e) {
			throw new Exception("Error while adding the producto to the Cart." , e);
		}
	}


	
	
	/**
	 * Metodo que devuelve informacion basica de la Cart.
	 * @param cartOid
	 * @return
	 * @throws Exception 
	 */
	@Transactional( readOnly = true )
	public CartBasicDetailsDTO getCartBasicDetails( @NotNull String cartOid ) throws Exception {
		try {
			Cart cart = this.cartRepo.findById( cartOid ).orElseThrow( ()-> new RuntimeException("No existe ninguna carta con el oid " + cartOid ) );
			Integer cantidadDeProductos = this.cartProdutRepo.cantidadProductosPorCart( cartOid )  ;
			Integer precioFinal = this.calculateCartFinalPrice( cart );
			
			CartBasicDetailsDTO dto = new CartBasicDetailsDTO();
			dto.setOid( cart.getOid() );
			dto.setPrecionFinal( precioFinal );
			dto.setCartType( cart.getCartType() );
			dto.setCartStatus( cart.getStatus() );
			dto.setCantidadDeitems( cantidadDeProductos == null ? 0 : cantidadDeProductos );
			return dto;
	
		} catch (Exception e) {
			throw new Exception("Error al consultar la informacion basica del Cart" , e);
		}
	}
	
	


	/**
	 * Metodo que devuelve la informacion basica del cart + todos los productos agregados en la misma.
	 * @param cartOid
	 * @return
	 * @throws Exception
	 */
	@Transactional( readOnly = true )
	public CartDetailDTO getCartDetails( @NotNull String cartOid ) throws Exception {
		this.validateCartExist( cartOid );
		try {
			CartDetailDTO detailDTO = new CartDetailDTO();
			CartBasicDetailsDTO basicInfoDTO = this.getCartBasicDetails( cartOid );
			detailDTO = this.modelMapper.map(basicInfoDTO, CartDetailDTO.class);
			
			Set<CartProductDTO > products =  this.cartProdutRepo.findProductsByCartOid( cartOid ).stream()
											  .map( d -> this.modelMapper.map(d, CartProductDTO.class))
											  .collect( Collectors.toSet() );
			detailDTO.setProductos( products );
			return detailDTO;
		} catch (Exception e) {
			throw new Exception("Error al obtener el detalle del cart" , e);
		}
	}
	
	
	
	
	
	/**
	 * Metodo que elimina una cart y todos los productos agregados en ella.
	 * @param cartOid
	 * @throws Exception 
	 */
	@Transactional( rollbackFor = Exception.class )
	public void deleteCart( @NotNull String cartOid ) throws Exception {
		try {
			this.validateCartExist( cartOid );
			this.logger.info("Comenzando proceso de eliminacion de card " + cartOid );
			this.cartRepo.deleteById( cartOid );
			this.cartProdutRepo.deleteByCartOid( cartOid );
			this.logger.info("Finalizando proceso de eliminacion de card " + cartOid );	
		}catch (Exception e) {
			throw new Exception("Error al eliminar el card " + cartOid , e);
		}
		
	}
	
	
	
	
	/**
	 * Metood para eliminar un producto de la cart.
	 * @param cartOid
	 * @param productOid
	 */
	@Transactional( rollbackFor = Exception.class )
	public void deleteProductFromCart( @NotNull String cartOid, @NotNull String productOid ) {
		this.validateCartExist( cartOid );
		this.validateProductExist( productOid );
		this.cartProdutRepo.deleteProductFromCart( cartOid, productOid );
	}
	
	
	
	/**
	 * Metodo que busca todos los carts con fecha anterior al dateLimit enviado como parametro.
	 * @param dateLimit
	 * @return
	 */
	@Transactional( readOnly = true )
	public List<String> findUnsedCarts( @NotNull Date dateLimit ){
		return this.cartRepo.findCartsNotUse( new Timestamp( dateLimit.getTime() ) );
	}
	

	
	/**
	 * Metodo para finalizar la cart.
	 * @param cartOid
	 * @throws Exception 
	 */
	@Transactional( rollbackFor = Exception.class )
	public void finishCart(@NotNull String cartOid) throws Exception {
		try {
			Cart cart = this.validateCartExist( cartOid );
			cart.setStatus( CartStatus.FINISH );
			this.cartRepo.save( cart );	
		} catch (Exception e) {
			throw new Exception("Error al finalizar la cart" , e );
		}
		
	}

	
	
	/**
	 * Metodo que calcula el precio total de la cart haciendo los descuentos correspondientes dependiendo de la cantidad de productos y de si es una Cart promocionable o no.
	 * @param cart
	 * @return
	 */
	private int calculateCartFinalPrice( Cart cart ) {
		
		Integer precioFinal = this.cartProdutRepo.precioFinalCart( cart.getOid() );
		Integer cantidadDeProductosCart = this.cartProdutRepo.cantidadProductosPorCart( cart.getOid() ) ;
		
		if( precioFinal == null ) return 0;
		
		// Buscar porcentaje de descuento en el application properties
		if(  cart.getCartType().equals( CartType.PROMOTION ) ) {
			precioFinal = ( precioFinal * ( 100 - this.descuentoPromocion ) ) / 100;
		}
		
		// Si tiene mas de n productos , tambien hacerle descuento y buscarlo en el properties.
		if( this.cantidadDeProductosParaDescuento != null && cantidadDeProductosCart > this.cantidadDeProductosParaDescuento ) precioFinal = ( precioFinal * ( 100 - this.descuentoPorCantidadProductos ) ) / 100;
		
		return precioFinal;
	}



	
	/**
	 * Metodo que valida si la Cart existe
	 * @param cartOid
	 */
	private Cart validateCartExist( @NotNull String cartOid  ) {
		return this.cartRepo.findById( cartOid ).orElseThrow( ()-> new RuntimeException("No existe ninguna carta con el oid " + cartOid ) );
	}
	
	
	
	/**
	 * Metodo que valida si el producto existe.
	 * @param productOid
	 * @return
	 */
	private Product validateProductExist( @NotNull String productOid ) {
		return this.productRepo.findById( productOid ).orElseThrow(()-> new RuntimeException("No existe ningun producto con el oid " + productOid ) );
	}






}
