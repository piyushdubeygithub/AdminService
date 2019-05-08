package com.prosmv.form.modelattributre;

import javax.validation.constraints.NotNull;

import com.prosmv.annotations.company.IsCompanyExist;
import com.prosmv.annotations.groups.CompanyGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.constants.message.ValidationMessageCode;

/**
 * This class is a model attribute used for company id and validate it.
 * 
 * @author piyush
 *
 */
public class CompanyIdModel {

	@NotNull(message = ValidationMessageCode.COMPANY_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsCompanyExist(groups = CompanyGroup.class)
	private Long companyId;

	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @param companyId
	 */
	public CompanyIdModel(@NotNull(message = "company.id.required", groups = NotNullGroup.class) Long companyId) {
		super();
		this.companyId = companyId;
	}

}
