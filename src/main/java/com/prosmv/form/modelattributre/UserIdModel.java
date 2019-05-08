package com.prosmv.form.modelattributre;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.annotations.groups.UserGroup;
import com.prosmv.annotations.user.IsUserAlreadyExist;
import com.prosmv.constants.message.ValidationMessageCode;

/**
 * This class is used for accessing request param user id.
 * 
 * @author piyush
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserIdModel {

	@NotNull(message = ValidationMessageCode.USER_ID_CANNOT_BE_NULL, groups = NotNullGroup.class)
	@IsUserAlreadyExist(groups = UserGroup.class)
	private Long userId;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @param userId
	 */
	public UserIdModel(@NotNull(message = "user.id.required", groups = NotNullGroup.class) Long userId) {
		super();
		this.userId = userId;
	}

	/**
	 * 
	 */
	public UserIdModel() {
		super();
	}

}
