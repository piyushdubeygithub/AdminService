package com.prosmv.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MachineForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2386170580868489525L;

	@NotNull(message = ValidationMessageCode.MACHINE_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotEmpty(message = ValidationMessageCode.MACHINE_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	private String machineName;

	private int rpm;

	private int allowance;

	private String machineType;

	private String machineColor;

	@NotNull(message = ValidationMessageCode.FACTORY_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotEmpty(message = ValidationMessageCode.FACTORY_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	private String factoryName;

	@NotNull(message = ValidationMessageCode.STITCH_CLASS_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotEmpty(message = ValidationMessageCode.STITCH_CLASS_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	private String stitchClassName;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getStitchClassName() {
		return stitchClassName;
	}

	public void setStitchClassName(String stitchClassName) {
		this.stitchClassName = stitchClassName;
	}
}
