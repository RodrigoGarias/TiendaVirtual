package com.danaide.tiendavirtual.model;


import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class PersistentObject {

	@Id
	@Column(name = "oid")
	@GeneratedValue(generator = "generator")	
	@GenericGenerator(name = "generator", strategy = "org.hibernate.id.UUIDGenerator")
	protected String oid;

	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	
	
	
}
