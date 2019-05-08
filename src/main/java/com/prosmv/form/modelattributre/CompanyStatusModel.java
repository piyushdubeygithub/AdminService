package com.prosmv.form.modelattributre;

import javax.validation.Valid;

/**
 * This class is act as model attribute used for api endpoint request params to
 * change company status.
 * 
 * @author piyush
 *
 */
public class CompanyStatusModel {

	private boolean active;

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @param companyIdModel
	 * @param active
	 */
	public CompanyStatusModel(boolean active) {
		super();
		this.active = active;
	}

	/**
	 * 
	 */
	public CompanyStatusModel() {
		super();
	}

}
