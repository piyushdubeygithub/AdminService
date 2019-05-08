package com.prosmv.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Designation  implements Serializable{
	
	
	private static final long serialVersionUID = 411841315559428322L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String designationname;
	private int personelAllowance;
	private int contigencyAllowance;
	private int wagerate;
	private boolean deleted;
	@CreationTimestamp
	private Timestamp createdAt;
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	@ManyToOne
	private Company company;
	@OneToOne
	private User createdBy;
	@OneToOne
	private User updatedBy;
	
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
	public String getDesignationname() {
		return designationname;
	}
	public void setDesignationname(String designationname) {
		this.designationname = designationname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public int getWagerate() {
		return wagerate;
	}
	public void setWagerate(int wagerate) {
		this.wagerate = wagerate;
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
	
	
}
