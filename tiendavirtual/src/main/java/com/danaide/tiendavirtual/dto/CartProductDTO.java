package com.danaide.tiendavirtual.dto;


public class CartProductDTO {

    private ProductDTO product;
 
    private int cantidadProducto;

    
	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	
}
