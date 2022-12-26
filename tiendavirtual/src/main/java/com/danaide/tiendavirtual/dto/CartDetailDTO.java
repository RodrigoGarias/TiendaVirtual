package com.danaide.tiendavirtual.dto;

import java.util.HashSet;
import java.util.Set;

public class CartDetailDTO extends CartBasicDetailsDTO {
	
	private Set< CartProductDTO > productos;

	public Set<CartProductDTO> getProductos() {
		if( !( this.productos instanceof Set ) ) this.productos = new HashSet<>();
		return productos;
	}

	public void setProductos(Set<CartProductDTO> productos) {
		this.productos = productos;
	}

	
}
