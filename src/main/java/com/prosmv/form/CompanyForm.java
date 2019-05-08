package com.prosmv.form;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.company.IsCompanyEmailAlreadyExist;
import com.prosmv.annotations.company.IsCompanyMobileNumberAlreadyExist;
import com.prosmv.annotations.company.IsCompanyNameAlreadyExist;
import com.prosmv.annotations.groups.CompanyGroup;
import com.prosmv.annotations.groups.EmailGroup;
import com.prosmv.annotations.groups.MobileGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.annotations.groups.UserGroup;
import com.prosmv.annotations.user.IsUserNameAlreadyExist;
import com.prosmv.constants.message.ValidationMessageCode;
import com.prosmv.domain.Company;

/**
 * This class is form class used as json body to save or update {@link Company}
 * 
 * @author piyush
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyForm {


	@NotEmpty(message = ValidationMessageCode.COMPANY_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.COMPANY_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsCompanyNameAlreadyExist(groups = CompanyGroup.class)
	private String name;

	private String landLineNumber;

	@NotEmpty(message = ValidationMessageCode.MOBILE_NUMBER_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.MOBILE_NUMBER_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsCompanyMobileNumberAlreadyExist(groups = MobileGroup.class)
	private String mobileNumber;

	private String gstNumber;

	private String address;

	@NotEmpty(message = ValidationMessageCode.EMAIL_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.EMAIL_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@Email(message = ValidationMessageCode.INVALID_EMAIL_PATTERN, groups = EmailGroup.class/*
																							 * , regexp =
																							 */)
	@IsCompanyEmailAlreadyExist(groups = EmailGroup.class)
	private String email;

	@NotEmpty(message = ValidationMessageCode.COMPANY_PASSWORD_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.COMPANY_PASSWORD_CANNOT_BE_NULL, groups = NotNullGroup.class)
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = ValidationMessageCode.INVALID_PASSWORD_PATTERN)
	private String password;

	private String companyHead;

	@NotEmpty(message = ValidationMessageCode.COMPANY_USERNAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.COMPANY_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsUserNameAlreadyExist(groups = UserGroup.class)
	private String userName;

	private Timestamp lastPay;

	public Timestamp getLastPay() {
		return lastPay;
	}

	public void setLastPay(Timestamp lastPay) {
		this.lastPay = lastPay;
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


}
