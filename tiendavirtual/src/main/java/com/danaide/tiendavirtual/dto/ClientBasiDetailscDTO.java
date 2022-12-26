package com.danaide.tiendavirtual.dto;

import java.util.Set;

import com.danaide.tiendavirtual.model.Cart;

public class ClientBasiDetailscDTO {

	private String oid;
	
	private String dni;
	
	private String name;
	
	private String lastName;
	
	private String email;
	
	private String phone;

	private String activeCartOid;
	
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

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

	public String getActiveCartOid() {
		return activeCartOid;
	}

	public void setActiveCartOid(String activeCartOid) {
		this.activeCartOid = activeCartOid;
	}
	
	
	
}
