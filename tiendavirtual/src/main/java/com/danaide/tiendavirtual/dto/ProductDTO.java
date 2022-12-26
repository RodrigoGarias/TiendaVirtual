package com.danaide.tiendavirtual.dto;

import java.sql.Timestamp;
import java.util.Set;

import com.danaide.tiendavirtual.enums.ProductCategory;

public class ProductDTO {

	private String oid;
	
	private String name;
	
	private String description;
	
	private Timestamp expirationDate;

	private long price;
	
	private Set<Integer> historyPrices;

	private ProductCategory category;

	private byte[] fileimage;
	

	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

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

	public Set<Integer> getHistoryPrices() {
		return historyPrices;
	}

	public void setHistoryPrices(Set<Integer> historyPrices) {
		this.historyPrices = historyPrices;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
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
