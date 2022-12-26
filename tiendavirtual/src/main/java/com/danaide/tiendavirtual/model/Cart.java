package com.danaide.tiendavirtual.model;

import java.util.Set;

import com.danaide.tiendavirtual.enums.CartStatus;
import com.danaide.tiendavirtual.enums.CartType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table( name = "Cart" )
public class Cart extends AuditablePersistentObject {

	@NotNull( message = "The cart should have any type.")
	@Column( name = "cardType" , nullable = false , unique = false )
	private CartType cartType;

	@NotNull( message = "The cart should have any status.")
	@Column( name = "status" , nullable = false , unique = false )
	private CartStatus status;

	
	public Cart() {
		this.cartType = CartType.NORMAL;
		this.status = CartStatus.ACTIVE;
	}
	

	public CartType getCartType() {
		return cartType;
	}

	public void setCartType(CartType cartType) {
		this.cartType = cartType;
	}

	public CartStatus getStatus() {
		return status;
	}

	public void setStatus(CartStatus status) {
		this.status = status;
	}
	
}
