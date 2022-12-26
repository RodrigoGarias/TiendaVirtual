package com.danaide.tiendavirtual.model;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public abstract class PersistentObjectLogicalDelete extends PersistentObject {

	@NotNull( message = "Active column should not be null" )
	@Column( name = "active" , nullable = false )
	protected boolean active;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
}
