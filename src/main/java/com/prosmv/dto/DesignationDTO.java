package com.prosmv.dto;

import com.prosmv.domain.Company;
import com.prosmv.domain.Designation;
import com.prosmv.domain.User;

public class DesignationDTO {
	
	private String designationname;
	private int personelAllowance;
	private int contigencyAllowance;
	private int wagerate;
	private boolean deleted;
	private Company company;
	private User createdBy;
	private User updatedBy;
	
	public DesignationDTO(Designation designation) {
		if(designation != null) {
			this.designationname = designation.getDesignationname();
			this.personelAllowance = designation.getPersonelAllowance();
			this.contigencyAllowance = designation.getContigencyAllowance();
			this.wagerate = designation.getWagerate();
			this.deleted = designation.isDeleted();
			this.createdBy = designation.getCreatedBy();
			this.updatedBy = designation.getUpdatedBy();
		}
	}
	
	public String getDesignationname() {
		return designationname;
	}
	public void setDesignationname(String designationname) {
		this.designationname = designationname;
	}
	public int getPersonelAllowance() {
		return personelAllowance;
	}
	public void setPersonelAllowance(int personelAllowance) {
		this.personelAllowance = personelAllowance;
	}
	public int getContigencyAllowance() {
		return contigencyAllowance;
	}
	public void setContigencyAllowance(int contigencyAllowance) {
		this.contigencyAllowance = contigencyAllowance;
	}
	public int getWagerate() {
		return wagerate;
	}
	public void setWagerate(int wagerate) {
		this.wagerate = wagerate;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
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
	
}
