package com.danaide.tiendavirtual.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table( name = "price")
public class Price extends AuditablePersistentObject {

	@NotNull( message = "Number must not be null" )
	@Column( name = "number" , unique = false )
	private long number;

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
	
	
}
