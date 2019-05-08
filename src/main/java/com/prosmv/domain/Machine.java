package com.prosmv.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Machine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7846031681365600039L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long   id;
	@NotEmpty(message="Please enter valid machine name")
	@NotNull(message="Please enter valid machine name")
	private String name;
	private int rpm;
	private int allowance;
	@NotEmpty(message="Please enter valid machine type")
	@NotNull(message="Please enter valid machine type")
	private String machineType;
	private String machineColor;
	private boolean deleted;
	private boolean isActive;
	@ManyToOne
	private Factory factory;
	@OneToOne
	private StitchClass stitchClass;
	@CreationTimestamp
	private Timestamp createdAt;
	@UpdateTimestamp
	private Timestamp updatedAt;
	@OneToOne
	private User createdBy;
	@OneToOne
	private User updatedBy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRpm() {
		return rpm;
	}
	public void setRpm(int rpm) {
		this.rpm = rpm;
	}
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public String getMachineColor() {
		return machineColor;
	}
	public void setMachineColor(String machineColor) {
		this.machineColor = machineColor;
	}
	public StitchClass getStitchClass() {
		return stitchClass;
	}
	public void setStitchClass(StitchClass stitchClass) {
		this.stitchClass = stitchClass;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
