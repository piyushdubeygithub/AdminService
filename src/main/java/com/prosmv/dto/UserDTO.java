package com.prosmv.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.prosmv.domain.Factory;
import com.prosmv.domain.User;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8016732383376138864L;
	private Long id;
	private String username;
	private String name;
	private String password;
	private String email;
	private boolean isActive;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private List<FactoryDTO> factories;
	private CompanyDTO company;
	private String mobileNumber;
	private String roleName;

	public UserDTO(User user) {
		if (user != null) {
			this.id = user.getId();
			this.username = user.getUsername();
			this.name = user.getName();
			this.email = user.getEmail();
			this.createdAt = user.getCreatedAt();
			this.updatedAt = user.getUpdatedAt();
			this.mobileNumber = user.getMobileNumber();
			this.isActive = user.isActive();
			if(user.getRole() != null) {
				this.roleName = user.getRole().getRoleName();
			}			
//			this.company = new CompanyDTO(user.getCompany());
			factories = new ArrayList<>();
			if (user.getFactories() != null) {
				for (Factory factory : user.getFactories()) {
					factories.add(new FactoryDTO(factory));
				}
			}
		}
	}

	public UserDTO(User user, String username) {
		if(user != null) {
			this.username = user.getUsername();
			this.id = user.getId();
			if(user.getRole() != null) {
				this.roleName = user.getRole().getRoleName();
			}
		}
	}

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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<FactoryDTO> getFactoryDTOs() {
		return factories;
	}

	public void setFactoryDTOs(List<FactoryDTO> factoryDTOs) {
		this.factories = factoryDTOs;
	}

	public CompanyDTO getCompanyDTO() {
		return company;
	}

	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.company = companyDTO;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
