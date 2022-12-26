package com.danaide.tiendavirtual.dto;

public class CategoryDTO {

	private String categoria;
	
	private int cantidadProductosPorCategoria;
	
	public CategoryDTO( String categoria , int cantidadProductosPorCategoria ) {
		this.categoria = categoria;;
		this.cantidadProductosPorCategoria = cantidadProductosPorCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCantidadProductosPorCategoria() {
		return cantidadProductosPorCategoria;
	}

	public void setCantidadProductosPorCategoria(int cantidadProductosPorCategoria) {
		this.cantidadProductosPorCategoria = cantidadProductosPorCategoria;
	}
	
	
	
}
