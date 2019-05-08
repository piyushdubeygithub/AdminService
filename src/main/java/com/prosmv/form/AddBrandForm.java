package com.prosmv.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.brand.IsBrandNameAlreadyExist;
import com.prosmv.annotations.groups.BrandGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;

/**
 * This class is json body for add brand api end point.
 * 
 * @author piyush
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddBrandForm {

	@NotNull(message = ValidationMessageCode.BRAND_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@NotEmpty(message = ValidationMessageCode.BRAND_NAME_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsBrandNameAlreadyExist(groups = BrandGroup.class)
	private String brandName;

	/**
	 * @return the brandName
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * @param customerIdModel
	 * @param brandName
	 */
	public AddBrandForm(@NotNull(message = "brand.name.required", groups = NotNullGroup.class) @NotEmpty(message = "brand.name.required", groups = NotNullGroup.class) String brandName) {
		super();
		this.brandName = brandName;
	}

	/**
	 * 
	 */
	public AddBrandForm() {
		super();
	}

}
