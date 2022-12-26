package com.danaide.tiendavirtual.dto;

public class DescuentoDTO {

	private int descuentoPorDiaPromocion;
	
	private Integer cantidadDeProductosParaDescuento;
	
	private int descuentoPorCantidadDeProductos;
	
	
	public DescuentoDTO( int descuentoPorDiaPromocionl , Integer cantidadDeProductosParaDescuento , int descuentoPorCantidadDeProductos ) {
		this.descuentoPorDiaPromocion = descuentoPorDiaPromocionl;
		this.cantidadDeProductosParaDescuento = cantidadDeProductosParaDescuento;
		this.descuentoPorCantidadDeProductos = descuentoPorCantidadDeProductos;
	}
	

	public int getDescuentoPorDiaPromocion() {
		return descuentoPorDiaPromocion;
	}

	public void setDescuentoPorDiaPromocion(int descuentoPorDiaPromocion) {
		this.descuentoPorDiaPromocion = descuentoPorDiaPromocion;
	}

	public Integer getCantidadDeProductosParaDescuento() {
		return cantidadDeProductosParaDescuento;
	}

	public void setCantidadDeProductosParaDescuento(Integer cantidadDeProductosParaDescuento) {
		this.cantidadDeProductosParaDescuento = cantidadDeProductosParaDescuento;
	}

	public int getDescuentoPorCantidadDeProductos() {
		return descuentoPorCantidadDeProductos;
	}

	public void setDescuentoPorCantidadDeProductos(int descuentoPorCantidadDeProductos) {
		this.descuentoPorCantidadDeProductos = descuentoPorCantidadDeProductos;
	}
	
	
	
}
