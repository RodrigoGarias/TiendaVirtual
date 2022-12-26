package com.danaide.tiendavirtual.dto;

import com.danaide.tiendavirtual.enums.CartStatus;
import com.danaide.tiendavirtual.enums.CartType;

public class CartBasicDetailsDTO {
	
	private String oid;

	private long precionFinal;
	
	private long cantidadDeitems;
	
	private CartType cartType;
	
	private CartStatus cartStatus;

	
	public long getPrecionFinal() {
		return precionFinal;
	}

	public void setPrecionFinal(long precionFinal) {
		this.precionFinal = precionFinal;
	}

	public long getCantidadDeitems() {
		return cantidadDeitems;
	}

	public void setCantidadDeitems(long cantidadDeitems) {
		this.cantidadDeitems = cantidadDeitems;
	}

	public CartType getCartType() {
		return cartType;
	}

	public void setCartType(CartType cartType) {
		this.cartType = cartType;
	}

	public CartStatus getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(CartStatus cartStatus) {
		this.cartStatus = cartStatus;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	
	
}
