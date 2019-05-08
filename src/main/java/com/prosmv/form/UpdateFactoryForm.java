package com.prosmv.form;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.groups.EmailGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.enums.FactoryMemberShip;
import com.prosmv.constants.message.ValidationMessageCode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateFactoryForm {

	@NotEmpty(message = ValidationMessageCode.MOBILE_NUMBER_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.MOBILE_NUMBER_CANNOT_BE_NULL, groups = NotNullGroup.class)
	private String mobileNumber;

	private String address;

	@NotEmpty(message = ValidationMessageCode.EMAIL_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.EMAIL_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@Email(message = ValidationMessageCode.INVALID_EMAIL_PATTERN, groups = EmailGroup.class/*
																							 * , regexp =
																							 * "^[\\\\\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\\\\\.[\\\\\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\\\\\.)+[a-zA-Z]{2,6}$"
																							 */)
	private String email;

	private FactoryMemberShip membership;

	private Timestamp licenseExpDate;

	private Timestamp licenseIssueDate;

	private Long companyId;
	
	private Long factoryId;


	private boolean isActive;


	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	/**
	 * @return the membership
	 */
	public FactoryMemberShip getMembership() {
		return membership;
	}

	/**
	 * @param membership the membership to set
	 */
	public void setMembership(FactoryMemberShip membership) {
		this.membership = membership;
	}

	public Timestamp getLicenseExpDate() {
		return licenseExpDate;
	}

	public void setLicenseExpDate(Timestamp licenseExpDate) {
		this.licenseExpDate = licenseExpDate;
	}

	public Timestamp getLicenseIssueDate() {
		return licenseIssueDate;
	}

	public void setLicenseIssueDate(Timestamp licenseIssueDate) {
		this.licenseIssueDate = licenseIssueDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}


}
