package com.prosmv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CustomerSupplier implements Serializable {

	private static final long serialVersionUID = 4552986421038840364L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	private String mobileNumber;
	private String email;
	private String customerType;
	private boolean isActive;
	private boolean isDeleted;
	@OneToMany
	private List<Brand> brands;
	@ManyToOne
	private Factory factory;
	@OneToOne
	private User createdBy;
	@OneToOne
	private User updatedBy;

	public CustomerSupplier(String name, String address, String mobileNumber, String email, String customerType) {
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.customerType = customerType;
	}
	
	public CustomerSupplier() {
	}

	public Long getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setCustomerId(Long customerId) {
		this.id = customerId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setEmail(String emailId) {
		this.email = emailId;
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

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
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


	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
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

}
