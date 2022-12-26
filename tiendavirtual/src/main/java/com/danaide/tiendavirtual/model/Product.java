package com.danaide.tiendavirtual.model;

import java.sql.Timestamp;
import java.util.Set;

import com.danaide.tiendavirtual.enums.ProductCategory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;


@Entity
@Table( name = "Product" )
public class Product extends PersistentObjectLogicalDelete {

	@NotNull( message = "Product name must not be null" )
	@Column( name = "name" , length = 100 , unique = true , nullable = false )
	private String name;
	
	@Column( name = "description" , length = 250 , unique = false , nullable = true )
	private String description;
	
	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "expirationDate" )
	private Timestamp expirationDate;

	@NotNull( message = "Product price must not be null" )
	@Column(name = "price" , unique = false , nullable = false )
	private long price;
	
	@OneToMany( cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	@JoinColumn(name = "product_oid")
	private Set<Price> historyPrices;

	@NotNull( message = "Product category must not be null" )
	@Column( name = "category" , unique = false , nullable = false )
	private ProductCategory category;
	
	@Column( name = "file_image" , unique = false , nullable = true )
	@Lob()
	private byte[] fileimage;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Set<Price> getHistoryPrices() {
		return historyPrices;
	}

	public void setHistoryPrices(Set<Price> historyPrices) {
		this.historyPrices = historyPrices;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getFileimage() {
		return fileimage;
	}

	public void setFileimage(byte[] fileimage) {
		this.fileimage = fileimage;
	}
	
	
}
