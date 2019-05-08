package com.prosmv.form.modelattributre;

import javax.validation.constraints.NotNull;

import com.prosmv.constants.message.ValidationMessageCode;

/**
 * This class is used to validate the request param permissionId for operations.
 * 
 * @author piyush
 *
 */
public class PermissionIdModel {

	@NotNull(message = ValidationMessageCode.PERMISSION_ID_CANNOT_BE_NULL)
	private Long permissionId;

	/**
	 * @return the permissionId
	 */
	public Long getPermissionId() {
		return permissionId;
	}

	/**
	 * @param permissionId the permissionId to set
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	/**
	 * @param permissionId
	 */
	public PermissionIdModel(@NotNull Long permissionId) {
		super();
		this.permissionId = permissionId;
	}

	/**
	 * 
	 */
	public PermissionIdModel() {
		super();
	}

}
