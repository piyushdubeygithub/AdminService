package com.prosmv.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;
import com.prosmv.domain.Designation;

/**
 * This class is used as a form json body for creating {@link Designation}
 * 
 * @author piyush
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DesignationForm {

	@NotEmpty(message = ValidationMessageCode.DESIGNATION_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotNull(message = ValidationMessageCode.DESIGNATION_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	private String designationname;

	@Min(value = 1, message = ValidationMessageCode.MINIMUM_PERSONAL_ALLOWANCE_REQUIRED)
	private int personelAllowance;

	@Min(value = 1, message = ValidationMessageCode.MINIMUM_CONTIGENCE_ALLOWANCE_REQUIRED)
	private int contigencyAllowance;

	private int wagerate;

	private Long companyId;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

}
