package com.prosmv.form;

import org.springframework.lang.NonNull;

public class CustomerForm {

	@NonNull
	private String customerName;
	private String address;
	private String mobileNumber;
	private String email;
	private String customerType;
	private Long factoryId;

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public Long getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}

	@Override
	public String toString() {
		return "CustomerForm [customerName=" + customerName + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", customerType=" + customerType + ", factoryId=" + factoryId + "]";
	}

}
