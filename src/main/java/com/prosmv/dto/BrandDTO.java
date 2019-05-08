package com.prosmv.dto;

import java.io.Serializable;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.prosmv.domain.Brand;
import com.prosmv.domain.CustomerSupplier;
import com.prosmv.domain.User;

public class BrandDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8402855456603227787L;

	private Long id;
	private String name;
	private boolean isDeleted;
	private CustomerSupplier customer;
	private User createdBy;
	private User updatedBy;
	
	public BrandDTO(Brand brand) {
		if(brand != null) {
			this.id = brand.getId();
			this.name = brand.getName();
			this.isDeleted = brand.isDeleted();
			this.customer = brand.getCustomer();
			this.createdBy = brand.getCreatedBy();
			this.updatedBy = brand.getUpdatedBy();
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public CustomerSupplier getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerSupplier customer) {
		this.customer = customer;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public User getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
