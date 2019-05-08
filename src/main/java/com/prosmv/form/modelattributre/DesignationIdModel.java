package com.prosmv.form.modelattributre;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.designation.IsDesignationAlreadyExist;
import com.prosmv.annotations.groups.DesignationGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;

/**
 * This model class is used to accept request param designation id and validate
 * it.
 * 
 * @author piyush
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DesignationIdModel {

	@NotNull(message = ValidationMessageCode.DESIGNATION_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsDesignationAlreadyExist(groups = DesignationGroup.class)
	private Long designationId;

	/**
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	/**
	 * @param designationId
	 */
	public DesignationIdModel(
			@NotNull(message = "designation.id.required", groups = NotNullGroup.class) Long designationId) {
		super();
		this.designationId = designationId;
	}

	/**
	 * 
	 */
	public DesignationIdModel() {
		super();
	}

}
