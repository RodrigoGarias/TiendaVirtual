package com.danaide.tiendavirtual.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.danaide.tiendavirtual.dto.DescuentoDTO;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ApplicationPropertiesService {

	@Value("${porcentage.descuento.promocion:0}")
	private int  descuentoPromocion;

	@Value("${cantidad.productos.para.descuento}")
	private Integer cantidadDeProductosParaDescuento;
	
	@Value("${descuento.cantidad.productos:0}")
	private int descuentoPorCantidadProductos;

	
	public DescuentoDTO getDescuentos() {
		return new DescuentoDTO(
			this.descuentoPromocion,
			this.cantidadDeProductosParaDescuento,
			this.descuentoPorCantidadProductos
		);
	}
	
}
