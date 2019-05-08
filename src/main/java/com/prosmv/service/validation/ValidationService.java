package com.prosmv.service.validation;

import com.prosmv.domain.Brand;
import com.prosmv.domain.Company;
import com.prosmv.domain.CustomerSupplier;
import com.prosmv.domain.Designation;
import com.prosmv.domain.Factory;
import com.prosmv.domain.User;

/**
 * This service is used for validation purpose.
 * 
 * @author piyush
 *
 */
public interface ValidationService {

	/**
	 * This method is used to validate is the company exist by company id.
	 * 
	 * @param companyId id of company {@link Company}
	 * @return either {@code true} or {@code false}
	 */
	public boolean isCompanyAlreadyExist(Long companyId);

	/**
	 * This method is used to validate is company is already exist with comapny
	 * name.
	 * 
	 * @param companyName company name
	 * @return either {@code true} or {@code false}
	 */
	public boolean isComapnyNameAlreadyExist(String companyName);

	/**
	 * This method is used to validate is user already exist with user id.
	 * 
	 * @param userId id of {@link User}
	 * @return either {@code false} or {@code true}
	 */
	public boolean isUserAlreadyExist(Long userId);

	/**
	 * This method is used to validate is user already exist with user name.
	 * 
	 * @param userName user name
	 * @return either {@code false} or {@code true}
	 */
	public boolean isUserNameAlreadyExist(String userName);

	/**
	 * This method is used to validate is the customer exist by customer id.
	 * 
	 * @param customerId id of {@link CustomerSupplier}
	 * @return either {@code true} or {@code false}
	 */
	public boolean isCustomerAlreadyExist(Long customerId);

	/**
	 * This method is used to validate is the customer exist by customer name.
	 * 
	 * @param customerName name of {@link CustomerSupplier}
	 * @return
	 */
	public boolean isCustomerNameAlreadyExist(String customerName);

	/**
	 * This method is used to validate is the Brand exist by Brand id.
	 * 
	 * @param branchId id of {@link Brand}
	 * @return either {@code true} or {@code false}
	 */
	public boolean isBrandAlreadyExist(Long brandId);

	/**
	 * This method is used to validate is the brand exist by brand name.
	 * 
	 * @param brandName name of {@link Brand}
	 * @return either {@code true} or {@code false}
	 */
	public boolean isBrandNameAlreadyExist(String brandName);

	/**
	 * This method is used to validate is the designation exist by designation id.
	 * 
	 * @param designationId id of {@link Designation}
	 * @return either {@code true} or {@code false}
	 */
	public boolean isDesignationAlreadyExist(Long designationId);

	/**
	 * This method is used to validate is the designation exist by designation name.
	 * 
	 * @param designationName name of {@link Designation}
	 * @return either {@code true} or {@code false}
	 */
	public boolean isDesignationNameAlreadyExist(String designationName);

	/**
	 * This method is used to validate is the factory exist by factory id.
	 * 
	 * @param factoryId id of {@link Factory}
	 * @return either {@code true} or {@code false}
	 */
	public boolean isFactoryAlreadyExist(Long factoryId);

	/**
	 * This method is used to validate is the factory exist by factory name.
	 * 
	 * @param factoryName name of {@link Factory}
	 * @return either {@code true} or {@code false}
	 */
	public boolean isFactoryNameAlreadyExist(String factoryName);
	
	/**
	 * This method is used to validate is the company email already exist or not.
	 * @param email email id
	 * @return either {@code true} or {@code false}
	 */
	public boolean isCompanyEmailAlreadyExist(String email);
}
