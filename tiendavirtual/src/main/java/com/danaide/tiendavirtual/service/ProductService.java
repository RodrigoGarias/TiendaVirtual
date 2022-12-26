package com.danaide.tiendavirtual.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danaide.tiendavirtual.controller.BaseRestController;
import com.danaide.tiendavirtual.dto.CategoryDTO;
import com.danaide.tiendavirtual.dto.ProductDTO;
import com.danaide.tiendavirtual.enums.ProductCategory;
import com.danaide.tiendavirtual.model.Product;
import com.danaide.tiendavirtual.repository.ProductRepo;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger( ProductService.class.getName() );
	
	private @Autowired ProductRepo productRepo;
	
	private @Autowired ModelMapper modelMapper;
	
	
	
	@Transactional( readOnly = true )
	public Set<Product> getList( Integer page, Integer size , ProductCategory category ) throws Exception {
		try {
			Integer categoryOrdinal = category != null ? category.ordinal() : null;
			return ( page != null && size != null ) ? this.productRepo.pageableList( size , page , categoryOrdinal ) : this.productRepo.completeList( categoryOrdinal ); 
		} catch (Exception e) {
			throw new Exception( "Error while consulting the products." , e );
		}
	}


	
	public Set<CategoryDTO> getProductsCategoryList() {
		return Stream.of( ProductCategory.values() )
				.map( val -> new CategoryDTO( val.name(), this.productRepo.getAmountOfProductsByCategory(val) )  )
				.sorted( (val1, val2) -> val1.getCategoria().toLowerCase().compareTo( val2.getCategoria().toLowerCase() ) )
				.collect( Collectors.toSet() );
	}

	
	
	/**
	 * Metodo para Agregar un producto al sistema.
	 * @param productDTO
	 * @throws Exception
	 */
	@Transactional( rollbackFor = Exception.class )
	public void addProduct( ProductDTO productDTO ) throws Exception {
		try {
			Product prod = 	this.modelMapper.map( productDTO, Product.class );
			this.productRepo.save( prod );
		} catch (Exception e) {
			throw new Exception("Error al insertar el producto." , e );
		}
	}
	
	

}
