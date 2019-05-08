package com.prosmv.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.prosmv.domain.Machine;
import com.prosmv.domain.StitchClass;
import com.prosmv.domain.User;

public class MachineDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5854568857993323698L;

	private Long   id;
	private String machineName;
	private int rpm;
	private int allowance;
	private String machineType;
	private String machineColor;
	private StitchClass stitchClass;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private User createdBy;
	private User updatedBy;
	
	public MachineDTO(Machine machine) {
      if(machine != null) {
    	  this.id = machine.getId();
    	  this.machineName = machine.getName();
    	  this.rpm = machine.getRpm();
    	  this.allowance = machine.getAllowance();
    	  this.machineType = machine.getMachineType();
    	  this.machineColor = machine.getMachineColor();
    	  this.createdAt = machine.getCreatedAt();
    	  this.updatedAt = machine.getUpdatedAt();
    	  this.createdBy = machine.getCreatedBy();
    	  this.updatedBy = machine.getUpdatedBy();
      }
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
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
}
