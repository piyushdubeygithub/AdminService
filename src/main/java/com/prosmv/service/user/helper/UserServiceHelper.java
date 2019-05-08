package com.prosmv.service.user.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.prosmv.constants.message.ServiceMessageCode;
import com.prosmv.domain.Company;
import com.prosmv.domain.User;
import com.prosmv.dto.UserDTO;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.exception.UserException;
import com.prosmv.form.UpdateUserForm;
import com.prosmv.form.UserForm;
import com.prosmv.service.user.UserService;
import com.prosmv.util.ResponseHandler;

/**
 * This helper class is used to access services related to user operation.
 * 
 * @author piyush
 *
 */
@Service
public class UserServiceHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceHelper.class);

	@Autowired
	private UserService userService;

	/**
	 * This helper method will access {@link UserService} to create a {@link User}.
	 * 
	 * @param userForm
	 *            {@link UserForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO saveUser(UserForm userForm) {
		try {
			userService.saveUser(userService.getUser(userForm));
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.USER_CREATED_SUCCESSFULLY, null,
					true, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException(ServiceMessageCode.UNABLE_TO_CREATE_USER);
		}
	}

	/**
	 * This helper method will access {@link UserService} to update {@link User}.
	 * 
	 * @param userId
	 *            id of updating {@link User}
	 * @param userForm
	 *            {@link UserForm} with updated details
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO updateUser(UpdateUserForm userForm) {
		try {
			userService.updateUser(userForm);
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.USER_UPDATED_SUCCESSFULLY, null,
					true, HttpStatus.OK);
		} catch (Exception e) {
			throw new UserException(ServiceMessageCode.UNABLE_TO_UPDATE_USER);
		}
	}

	/**
	 * This helper method is used to access the service to activate {@link User}.
	 * 
	 * @param userId
	 *            id of {@link User}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO activateUser(Long userId) {
		try {
			userService.activateUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException(ServiceMessageCode.UNABLE_TO_ACTIVATE_USER);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.USER_ACTIVATED_SUCCESSFULLY, null, true,
				HttpStatus.OK);
	}

	/**
	 * This helper method is used to access the service to de activate {@link User}.
	 * 
	 * @param userId
	 *            id of {@link User}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO deActivateUser(Long userId) {
		try {
			userService.deActivateUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException(ServiceMessageCode.UNABLE_TO_DEACTIVATE_USER);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.USER_DEACTIVATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access the service to get all {@link User} by
	 * id of {@link Company}.
	 * 
	 * @param companyId
	 *            id of {@link Company}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getAllUser(Long companyId) {
		List<UserDTO> userDTOs = userService.getUserList(companyId);
		if (userDTOs.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.NO_USER_CREATED_YET, null, true,
					HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(userDTOs, ServiceMessageCode.USER_LIST_FETCHED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access the service to set {@link User} status.
	 * 
	 * @param userId
	 *            id of {@link User}
	 * @param isActive
	 *            {@code true} or {@code false}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO setUserStatus(Long userId, boolean isActive) {
		try {
			userService.setUserStatus(userId, isActive);
		} catch (Exception e) {
			throw new UserException(ServiceMessageCode.UNABLE_TO_SET_USER_STATUS);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.USER_STATUS_SET_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access {@link UserService#getUsers()} to get
	 * all {@link User}.
	 * 
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getAllUser() {
		List<UserDTO> userListDTO = userService.getUsers();
		if (userListDTO.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.NO_USER_CREATED_YET, null, true,
					HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(userListDTO, ServiceMessageCode.USER_LIST_FETCHED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access the {@link UserService#deleteUser(Long)}
	 * to delete {@link User}.
	 * 
	 * @param userId
	 *            id of {@link User}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO deleteUser(Long userId) {
		try {
			userService.deleteUser(userId);
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.USER_DELETED_SUCCESSFULLY, null,
					true, HttpStatus.OK);
		} catch (Exception e) {
			throw new UserException(ServiceMessageCode.UNABLE_TO_DELETE_USER);
		}
	}

	private User setUser(UserForm userForm) {
		return null;
	}


}
