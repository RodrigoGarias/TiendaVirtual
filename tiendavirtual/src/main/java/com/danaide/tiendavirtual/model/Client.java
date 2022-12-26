package com.danaide.tiendavirtual.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;



@Entity
@Table( name = "Client" )
public class Client extends AuditablePersistentObject {

	@NotNull( message = "DNI must not be null" )
	@Length ( max = 100 , message = "Name is too long. Must not have more than 10 digits.")
	@Column ( name = "dni" , nullable = false , unique = false , length = 10 )
	private String dni;
	
	@NotNull( message = "Name must not be null" )
	@Length ( max = 100 , message = "Name is too long. Must not have more than 100 digits.")
	@Column ( name = "name" , nullable = false , unique = false , length = 100 )
	private String name;
	
	@NotNull( message = "lastName must not be null" )
	@Length ( max = 100 , message = "lastName is too long. Must not have more than 100 digits.")
	@Column ( name = "lastName" , nullable = false , unique = false , length = 100 )
	private String lastName;
	
	@Length ( max = 200 , message = "Name is too long. Must not have more than 100 digits." )
	@Column ( name = "email" , nullable = true , unique = false , length = 200 )
	private String email;
	
	@NotNull( message = "phone must not be null" )
	@Column ( name = "phone" , nullable = false , unique = false , length = 200 )
	private String phone;
	
	@OneToMany( cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	@JoinColumn( name = "cart_oid" , nullable = true )
	//TODO : CAMBIAR COLUMNA DEL JOIN POR CLIENT_OID
	private Set<Cart> cart;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Set<Cart> getCart() {
		if( !(this.cart instanceof Set) ) this.cart = new HashSet<>(); 
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
	
	
	
}
