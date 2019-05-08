package com.prosmv.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.prosmv.domain.Company;
import com.prosmv.domain.Role;
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDTO {
	private Long id;
	private String roleName;
	private Long companyId;
	private String companyName;
	
	public RoleDTO(String roleName) {
		this.roleName = roleName;
	}
	
	public RoleDTO(Role role) {
		if(role != null) {
			this.id = role.getId();
			this.roleName = role.getRoleName();
			if(role.getCompany() != null) {
				Company company = role.getCompany();
				companyId = company.getId();
				companyName = company.getName();
			}
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
