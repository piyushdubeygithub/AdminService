package com.prosmv.form.modelattributre;

import javax.validation.constraints.NotNull;

import com.prosmv.annotations.factory.IsFactoryAlreadyExist;
import com.prosmv.annotations.groups.FactoryGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;

/**
 * This model class is used to accept request param factory id and validate it.
 * 
 * @author piyush
 *
 */
public class FactoryIdModel {

	@NotNull(message = ValidationMessageCode.FACTORY_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsFactoryAlreadyExist(groups = FactoryGroup.class)
	private Long factoryId;

	/**
	 * @return the factoryId
	 */
	public Long getFactoryId() {
		return factoryId;
	}

	/**
	 * @param factoryId the factoryId to set
	 */
	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}

	/**
	 * @param factoryId
	 */
	public FactoryIdModel(@NotNull(message = "factory.id.required") Long factoryId) {
		super();
		this.factoryId = factoryId;
	}

	/**
	 * 
	 */
	public FactoryIdModel() {
		super();
	}

}
