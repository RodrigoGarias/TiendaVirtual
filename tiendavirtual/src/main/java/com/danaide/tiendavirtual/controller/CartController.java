package com.danaide.tiendavirtual.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danaide.tiendavirtual.service.CartService;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping( "/api/priv/cart" )
public class CartController extends BaseRestController {

	private @Autowired CartService cartService;
	
	
	@GetMapping("/{cartOid}")
	public Map<String,Object> detailCart( @NotNull @PathVariable("cartOid") String cartOid  ) {
		return super.executeService( ()->{
			return this.cartService.getCartDetails( cartOid );
		});
	}
	
	
	@GetMapping("/preview/{cartOid}")
	public Map<String,Object> previewCart( @NotNull @PathVariable("cartOid") String cartOid  ) {
		return super.executeService( ()->{
			return this.cartService.getCartBasicDetails( cartOid );
		});
	}
	

	@DeleteMapping("/delete/{cartOid}")
	public Map< String , Object > deleteCart(  @NotNull @PathVariable("cartOid") String cartOid  ) {
		return super.executeVoidService( ()->{
			 this.cartService.deleteCart( cartOid );
		});
	}
	
	
	@PostMapping("/product/add")
	public Map< String , Object > addProductToCart( @NotNull @RequestParam("clientOid") String clientOid  , @NotNull @RequestParam("productOid") String productOid , @NotNull @RequestParam("cantidad") int cantidad){
		return super.executeService( ()->{
			 String cartOid = this.cartService.createCart( clientOid );
			 this.cartService.addProductToCart( productOid , cartOid , cantidad );
			 return this.cartService.getCartBasicDetails( cartOid );
		});
	}
	
	
	@DeleteMapping("/product/delete")
	public Map< String , Object > deleteProductFromCart(  @NotNull @RequestParam("cartOid") String cartOid  , @NotNull @RequestParam("productOid") String productOid  ) {
		return super.executeService( ()->{
			this.cartService.deleteProductFromCart( cartOid, productOid );
			return this.cartService.getCartBasicDetails( cartOid );
		});
	}
	
	
	@PutMapping("/state/{cartOid}")
	public Map< String , Object > finishCart(  @NotNull @PathVariable("cartOid") String cartOid ){
		return super.executeVoidService( ()-> {
			this.cartService.finishCart( cartOid );
		});
	}
	
	
}
