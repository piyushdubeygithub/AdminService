package com.prosmv.dto;

import java.io.Serializable;
import java.util.List;

import com.prosmv.domain.CustomerSupplier;

public class CustomerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7178330785283846026L;
	private Long id;
	private String name;
	private String address;
	private String mobileNumber;
	private String email;
	private String customerType;
	private boolean isActive;
	private boolean isDeleted;
	private List<BrandDTO> brands;
	private FactoryDTO factory;
	private int brandCount;
	
	public CustomerDTO(CustomerSupplier customerSupplier) {
		this.id = customerSupplier.getId();
		this.name = customerSupplier.getName();
		this.address = customerSupplier.getAddress();
		this.mobileNumber = customerSupplier.getMobileNumber();
		this.email = customerSupplier.getEmail();
		this.customerType = customerSupplier.getCustomerType();
		this.isActive = customerSupplier.isActive();
		this.isDeleted = customerSupplier.isDeleted();
		if(!customerSupplier.getBrands().isEmpty()) {
			this.brandCount = customerSupplier.getBrands().size();
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public List<BrandDTO> getBrands() {
		return brands;
	}
	public void setBrands(List<BrandDTO> brands) {
		this.brands = brands;
	}
	public FactoryDTO getFactory() {
		return factory;
	}
	public void setFactory(FactoryDTO factory) {
		this.factory = factory;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getBrandCount() {
		return brandCount;
	}

	public void setBrandCount(int brandCount) {
		this.brandCount = brandCount;
	}

}
