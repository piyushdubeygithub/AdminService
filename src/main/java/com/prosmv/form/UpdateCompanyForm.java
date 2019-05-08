package com.prosmv.form;

import java.sql.Timestamp;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.company.IsCompanyMobileNumberAlreadyExist;
import com.prosmv.annotations.groups.EmailGroup;
import com.prosmv.annotations.groups.MobileGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateCompanyForm {


	private String landLineNumber;

	@NotEmpty(message = ValidationMessageCode.MOBILE_NUMBER_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.MOBILE_NUMBER_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsCompanyMobileNumberAlreadyExist(groups = MobileGroup.class)
	private String mobileNumber;

	private String gstNumber;

	private String address;

	Long companyId;
	
	@NotEmpty(message = ValidationMessageCode.EMAIL_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.EMAIL_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@Email(message = ValidationMessageCode.INVALID_EMAIL_PATTERN, groups = EmailGroup.class/*
																							 */)
	private String email;

	@NotEmpty(message = ValidationMessageCode.COMPANY_PASSWORD_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.COMPANY_PASSWORD_CANNOT_BE_NULL, groups = NotNullGroup.class)
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = ValidationMessageCode.INVALID_PASSWORD_PATTERN)
	private String password;

	private String companyHead;

	@NotEmpty(message = ValidationMessageCode.COMPANY_USERNAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.COMPANY_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	private String userName;

	private Timestamp lastPay;

	public Timestamp getLastPay() {
		return lastPay;
	}

	public void setLastPay(Timestamp lastPay) {
		this.lastPay = lastPay;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyHead() {
		return companyHead;
	}

	public void setCompanyHead(String companyHead) {
		this.companyHead = companyHead;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}
