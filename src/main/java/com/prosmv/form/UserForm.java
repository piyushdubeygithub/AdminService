package com.prosmv.form;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.annotations.groups.UserGroup;
import com.prosmv.annotations.user.IsUserNameAlreadyExist;
import com.prosmv.constants.message.ValidationMessageCode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserForm {

	@NotEmpty(message = ValidationMessageCode.USERNAME_CANNOT_BE_NULL,groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.USERNAME_CANNOT_BE_NULL,groups = NotNullGroup.class)
	@IsUserNameAlreadyExist(groups = UserGroup.class)
	private String username;

	private String name;

	private String password;
	
	private String mobileNumber;

	@NotEmpty(message = "Please enter valid email")
	@NotNull(message = "Please enter valid email")
	@Email
	private String email;

	private boolean isActive;
	
	private Character deleted = 'N';

	private Long roleId;

	private List<String> factoryNames;

	@NotNull(message = ValidationMessageCode.COMPANY_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	private Long companyId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public List<String> getFactoryNames() {
		return factoryNames;
	}

	public void setFactoryNames(List<String> factoryNames) {
		this.factoryNames = factoryNames;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Character getDeleted() {
		return deleted;
	}

	public void setDeleted(Character deleted) {
		this.deleted = deleted;
	}

}
