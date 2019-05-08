package com.prosmv.dto;

import java.sql.Timestamp;

import com.prosmv.domain.StitchClass;

public class StitchClassDTO {

	private String name;
	private String description;
	private String machineType;
	private int needleCount;
	private int needleThread;
	private int looperThread;
	private double threadRatio;
	private boolean isActive;
	private boolean isDeleted;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public StitchClassDTO(StitchClass stitchClass) {
		if (stitchClass != null) {
			this.name = stitchClass.getName();
			this.description = stitchClass.getDescription();
			this.machineType = stitchClass.getMachineType();
			this.needleCount = stitchClass.getNeedleCount();
			this.needleThread = stitchClass.getNeedleCount();
			this.looperThread = stitchClass.getLooperThread();
			this.threadRatio = stitchClass.getThreadRatio();
			this.isActive = stitchClass.isActive();
			this.isDeleted = stitchClass.isDeleted();
			this.createdAt = stitchClass.getCreatedAt();
			this.updatedAt = stitchClass.getUpdatedAt();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getThreadRatio() {
		return threadRatio;
	}

	public void setThreadRatio(double threadRatio) {
		this.threadRatio = threadRatio;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
