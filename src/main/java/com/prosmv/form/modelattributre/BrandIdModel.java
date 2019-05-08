package com.prosmv.form.modelattributre;

import javax.validation.constraints.NotNull;

import com.prosmv.annotations.brand.IsBrandAlreadyExist;
import com.prosmv.annotations.groups.BrandGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;

/**
 * This model class is used to accept request param brand id and validate it.
 * 
 * @author piyush
 *
 */
public class BrandIdModel {

	@NotNull(message = ValidationMessageCode.BRAND_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsBrandAlreadyExist(groups = BrandGroup.class)
	private Long branchId;

	/**
	 * @return the branchId
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	/**
	 * @param branchId
	 */
	public BrandIdModel(@NotNull(message = "brand.id.required", groups = NotNullGroup.class) Long branchId) {
		super();
		this.branchId = branchId;
	}

	/**
	 * 
	 */
	public BrandIdModel() {
		super();
	}

}
