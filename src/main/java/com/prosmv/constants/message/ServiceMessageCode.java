package com.prosmv.constants.message;

/**
 * This class is a constant class contains all the constant related to the
 * service messages.
 * 
 * @author piyush
 *
 */
public final class ServiceMessageCode {

	private ServiceMessageCode() {

	}

	public static final String UNABLE_TO_CREATE_COMPANY_USER = "company.user.creation.exception";

	public static final String UNABLE_TO_CREATE_FACTORY = "factory.creation.exception";

	public static final String COMPANY_CREATED_SUCCESSFULLY = "company.created.success";

	public static final String UNABLE_TO_CREATE_COMPANY = "company.creation.exception";

	public static final String TOKEN_EXPIRED = "token.expired.exception";
	
	public static final String UNABLE_TO_CREATE_COMPANY_USER_ROLES = "company.user.roles.creation.exception";

	public static final String COMPANIES_LIST_FETCHED_SUCCESSFULLY = "companies.list.fetch.success";

	public static final String NO_COMPANY_CREATED_YET = "company.list.empty";

	public static final String COMPANY_DEACTIVATED_SUCCESSFULLY = "company.deactivated.success";

	public static final String COMPANY_NOT_FOUND = "company.not.found";

	public static final String COMPANY_STATUS_CHANGED_SUCCESSFULLY = "company.status.change.success";

	public static final String COMPANY_DELETED_SUCCESSFULLY = "company.deleted.success";

	public static final String COMPANY_ACTIVATED_SUCCESSFULLY = "company.activated.success";

	public static final String COMPANY_UPDATED_SUCCESSFULLY = "company.updated.success";
	
	public static final String UNABLE_TO_DEACTIVATE_COMPANY = "company.deactivate.exception";

	public static final String UNABLE_TO_SET_COMPANY_STATUS = "company.status.update.exception";

	public static final String UNABLE_TO_DELETE_COMPANY = "company.delete.exception";

	public static final String UNABLE_TO_ACTIVATE_COMPANY = "company.activate.exception";

	public static final String UNABLE_TO_UPDATE_COMPANY = "company.update.exception";

	public static final String UNABLE_TO_DELETE_BRAND = "brand.delete.exception";

	public static final String BRAND_DELETED_SUCCESSFULLY = "brand.deleted.success";

	public static final String UNABLE_TO_ACTIVATE_CUSTOMER = "customer.activate.exception";

	public static final String CUSTOMER_ACTIVATED_SUCCESSFULLY = "customer.activated.success";

	public static final String UNABLE_TO_DEACTIVATE_CUSTOMER = "customer.deactivate.exception";

	public static final String CUSTOMER_DEACTIVATED_SUCCESSFULLY = "customer.deactivated.success";

	public static final String BRAND_LIST_FETCHED_SUCCESSFULLY = "brand.list.fetch.success";
	
	public static final String NO_BRAND_CREATED_YET = "brand.list.empty";
	
	public static final String UNABLE_TO_ADD_BRAND = "brand.create.exception";
	
	public static final String BRAND_ADDED_SUCCESSFULLY = "brand.added.successfully";
	
	public static final String DESIGNATION_DELETED_SUCCESSFULLY = "designation.deleted.successfully";

	public static final String UNABLE_TO_DELETE_DESIGNATION = "designation.delete.exception";
	
	public static final String NO_DESIGNATION_CREATED_YET = "designation.list.empty";
	
	public static final String DESIGNATION_LIST_FETCHED_SUCCESSFULLY = "designation.list.fetch.success";
	
	public static final String UNABLE_TO_DEACTIVATE_USER = "deactivate.user.exception";
	
	public static final String USER_DEACTIVATED_SUCCESSFULLY = "user.deactivated.success";
	
	public static final String UNABLE_TO_ACTIVATE_USER = "activate.user.exception";
	
	public static final String USER_ACTIVATED_SUCCESSFULLY = "user.activated.success";
	
	public static final String NO_USER_CREATED_YET = "user.list.empty";
	
	public static final String USER_LIST_FETCHED_SUCCESSFULLY = "user.list.fetch.success";
	
	public static final String UNABLE_TO_SET_USER_STATUS = "user.status.set.exception";

	public static final String USER_STATUS_SET_SUCCESSFULLY ="user.status.set.success";
	
	public static final String UNABLE_TO_DELETE_FACTORY = "factory.delete.exception";
	
	public static final String FACTORY_DELETED_SUCCESSFULLY = "factory.deleted.success";
	
	public static final String UNABLE_TO_SET_FACTORY_STATUS = "factory.status.set.exception";

	public static final String FACTORY_STATUS_SET_SUCCESSFULLY = "factory.status.set.success";
	
	public static final String UNABLE_TO_ACTIVATE_FACTORY = "factory.activate.exception";
	
	public static final String FACTORY_ACTIVATED_SUCCESSFULLY = "factory.activated.success";
	
	public static final String UNABLE_TO_DEACTIVATE_FACTORY = "factory.deactivate.exception";
	
	public static final String FACTORY_DEACTIVATED_SUCCESSFULLY = "factory.deactivated.success";
	
	public static final String NO_FACTORY_CREATED_YET = "factory.list.empty";
	
	public static final String FACTORY_LIST_FETCHED_SUCCESSFULLY = "factory.list.fetch.success";
	
	public static final String NO_AUTO_COMPLETE_COMPANY_FOUND = "auto.complete.company.list.empty";
	
	public static final String UNABLE_TO_DELETE_USER = "user.delete.exception";
	
	public static final String USER_DELETED_SUCCESSFULLY = "user.deleted.success";

	public static final String CUSTOMER_CREATED_SUCCESSFULLY = "customer.created.success";
	
	public static final String UNABLE_TO_CREATE_CUSTOMER = "customer.create.exception";
	
	public static final String CUSTOMER_UPDATED_SUCCESSFULLY = "customer.update.success";
	
	public static final String UNABLE_TO_UPDATE_CUSTOMER = "customer.update.exception";
	
	public static final String UNABLE_TO_CREATE_DESIGNATION = "designation.create.exception";
	
	public static final String DESIGNATION_CREATED_SUCCESSFULLY = "designation.created.success";
	
	public static final String UNABLE_TO_UPDATE_DESIGNATION = "designation.update.exception";
	
	public static final String DESIGNATION_UPDATED_SUCCESSFULLY = "designation.updated.success";
	
	public static final String FACTORY_CREATED_SUCCESSFULLY = "factory.created.success";

	public static final String UNABLE_TO_UPDATE_FACTORY = "factory.updated.exception";
	
	public static final String FACTORY_UPDATED_SUCCESSFULLY = "factory.updated.success";
	
	public static final String UNABLE_TO_SAVE_ROLE_PERMISSION = "role.permission.save.exception";

	public static final String ROLE_PERMISSION_SAVED_SUCCESSFULLY = "role.permission.save.success";
	
	public static final String UNABLE_TO_UPDATE_ROLE_PERMISSION = "role.permission.update.exception";
	
	public static final String ROLE_PERMISSION_UPDATED_SUCCESSFULLY = "role.permission.update.success";
	
	public static final String UNABLE_TO_DELETE_ROLE_BASED_PERMISSION = "role.permission.delete.exception";

	public static final String ROLE_BASED_PERMISSION_DELTED_SUCCESSFULLY = "role.permission.delete.success";
	
	public static final String NO_PERMISSIONS_AVAILABLE_TO_THIS_ROLE = "role.permission.list.empty";
	
	public static final String ROLE_BASED_PERMISSION_FETCHED_SUCCESSFULLY = "role.permission.fetch.success";

	public static final String USER_CREATED_SUCCESSFULLY = "user.created.success";
	
	public static final String UNABLE_TO_CREATE_USER = "user.creation.exception";
	
	public static final String USER_UPDATED_SUCCESSFULLY = "user.updated.success";
	
	public static final String UNABLE_TO_UPDATE_USER = "user.update.exception";
	
	public static final String NO_AUTO_COMPLETE_ROLES_AVAILABLE = "auto.complete.role.list.empty";
	
	public static final String AUTO_COMPLETE_ROLE_FOUND_SUCCESSFULLY = "auto.complete.role.list.fetch.success";

	public static final String FAILED_TO_UPLOAD_EMPTY_FILE = "empty.file.fail.upload";
	
	public static final String UNABLE_TO_UPLOAD_COMPANY_IMAGE = "company.logo.upload.exception";
	
	public static final String NO_AUTO_COMPLETE_FACTORY_AVAILABLE = "auto.complete.factory.list.empty";
	
	public static final String AUTO_COMPLETE_FACTORY_FOUND_SUCCESSFULLY = "auto.complete.factory.list.fetch.success";
	
	public static final String COMPANY_LOGO_HAS_BEEN_UPLOADED_SUCCESSFULLY = "company.logo.upload.success";
	
}
