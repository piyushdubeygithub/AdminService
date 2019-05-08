package com.prosmv.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.prosmv.domain.Company;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDTO {

	private Long id;
	private String name;
	private String landLineNumber;
	private String mobileNumber;
	private String gstNumber;
	private String address;
	private String email;
	private Long userCount = (long) 0;
	private Long factoryCount = (long) 0;
	private String contactPerson;
	private String userName;
	private Timestamp lastPay;
	private boolean isActive;
	private boolean deleted;
	private Timestamp startDate;
	private Timestamp endDate;
	private byte[] companyLogo;

	public CompanyDTO() {

	}

	public CompanyDTO(Long id, String name, boolean isActive, boolean deleted) {
		if (isActive && !deleted) {
			this.id = id;
			this.name = name;
			this.isActive = isActive;
			this.deleted = deleted;
		}
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public CompanyDTO(Company company, byte[] companyLogo) {
		if (company != null) {
			this.id = company.getId();
			this.name = company.getName();
			this.landLineNumber = company.getLandLineNumber();
			this.mobileNumber = company.getMobileNumber();
			this.gstNumber = company.getGstNumber();
			this.address = company.getAddress();
			this.email = company.getEmail();
			this.lastPay = company.getLastPay();
			this.startDate = company.getStartDate();
			this.isActive = company.isActive();
			this.deleted = company.isDeleted();
			this.contactPerson = company.getCompanyHead();
			if (company.getUser() != null) {
				this.userName = company.getUser().getUsername();
			}
			if (companyLogo!=null) {
				this.companyLogo = companyLogo;
			}
		}
	}

	public CompanyDTO(Company company, long userCount, long factoryCount, byte[] companyLogo) {

		if (company != null) {
			this.id = company.getId();
			this.name = company.getName();
			this.landLineNumber = company.getLandLineNumber();
			this.mobileNumber = company.getMobileNumber();
			this.gstNumber = company.getGstNumber();
			this.address = company.getAddress();
			this.email = company.getEmail();
			this.lastPay = company.getLastPay();
			this.startDate = company.getStartDate();
			this.isActive = company.isActive();
			this.contactPerson = company.getCompanyHead();
			if (company.getUser() != null) {
				this.userName = company.getUser().getUsername();
			}
			if (companyLogo.length > 0) {
				this.companyLogo = companyLogo;
			}
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

	public String getLandLineNumber() {
		return landLineNumber;
	}

	public void setLandLineNumber(String landLineNumber) {
		this.landLineNumber = landLineNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getLastPay() {
		return lastPay;
	}

	public void setLastPay(Timestamp lastPay) {
		this.lastPay = lastPay;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Long getUserCount() {
		return userCount;
	}

	public void setUserCount(Long userCount) {
		this.userCount = userCount;
	}

	public Long getFactoryCount() {
		return factoryCount;
	}

	public void setFactoryCount(Long factoryCount) {
		this.factoryCount = factoryCount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the companyLogo
	 */
	public byte[] getCompanyLogo() {
		return companyLogo;
	}

	/**
	 * @param companyLogo the companyLogo to set
	 */
	public void setCompanyLogo(byte[] companyLogo) {
		this.companyLogo = companyLogo;
	}

}
