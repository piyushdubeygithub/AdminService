package com.prosmv.form.modelattributre;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.customer.IsCustomerExist;
import com.prosmv.annotations.groups.CustomerGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;

/**
 * This model class is used to accept request param customer id and validate it.
 * 
 * @author piyush
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerIdModel {

	@NotNull(message = ValidationMessageCode.CUSTOMER_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsCustomerExist(groups = CustomerGroup.class)
	private Long customerId;

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @param customerId
	 */
	public CustomerIdModel(@NotNull(message = "customer.id.required", groups = NotNullGroup.class) Long customerId) {
		super();
		this.customerId = customerId;
	}

	/**
	 * 
	 */
	public CustomerIdModel() {
		super();
	}

}
