package com.danaide.tiendavirtual.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table( name = "cart_products" )
public class CartProducts extends PersistentObject {

	@ManyToOne( fetch = FetchType.EAGER , cascade =CascadeType.ALL )
	@JoinColumn( name = "cart_oid" , nullable = false )
    private Cart cart;
 
    @ManyToOne( fetch = FetchType.EAGER , cascade =CascadeType.PERSIST )
    @JoinColumn( name = "product_oid" , nullable = false )
    private Product product;
 
    @Column(name = "cantidad_producto")
    private int cantidadProducto;


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

    
}
