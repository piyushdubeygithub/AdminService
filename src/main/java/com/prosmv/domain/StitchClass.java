package com.prosmv.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class StitchClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7785403534478499679L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private String machineType;
	private int needleCount=0;
	private int needleThread=0;
	private int looperThread=0;
	private double threadRatio;
	private boolean isActive;
	private boolean isDeleted;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	@ManyToOne
	private Factory factory;
	@OneToOne
	private User createdBy;
	@OneToOne
	private User updatedBy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public int getNeedleCount() {
		return needleCount;
	}
	public void setNeedleCount(int needleCount) {
		this.needleCount = needleCount;
	}
	public int getNeedleThread() {
		return needleThread;
	}
	public void setNeedleThread(int needleThread) {
		this.needleThread = needleThread;
	}
	public int getLooperThread() {
		return looperThread;
	}
	public void setLooperThread(int looperThread) {
		this.looperThread = looperThread;
	}
	public void setThreadRatio(int threadRatio) {
		this.threadRatio = threadRatio;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setATctive(boolean isActive) {
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
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public double getThreadRatio() {
		return threadRatio;
	}
	public void setThreadRatio(double threadRatio) {
		this.threadRatio = threadRatio;
	}
	
}
