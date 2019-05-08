package com.prosmv.service.company.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.ObjectListing;
import com.prosmv.constants.enums.DocumentType;
import com.prosmv.constants.message.ServiceMessageCode;
import com.prosmv.domain.Company;
import com.prosmv.domain.Document;
import com.prosmv.domain.Factory;
import com.prosmv.domain.Role;
import com.prosmv.domain.User;
import com.prosmv.dto.CompanyDTO;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.exception.CompanyException;
import com.prosmv.exception.FactoryException;
import com.prosmv.exception.ImageUploadException;
import com.prosmv.exception.UserException;
import com.prosmv.form.CompanyForm;
import com.prosmv.form.UpdateCompanyForm;
import com.prosmv.service.aws.BucketService;
import com.prosmv.service.company.CompanyService;
import com.prosmv.service.factory.FactoryService;
import com.prosmv.service.role.RoleService;
import com.prosmv.service.user.UserService;
import com.prosmv.util.GenericUtils;
import com.prosmv.util.ResponseHandler;

/**
 * This Service class is used for comapny service responses send to controller.
 * 
 * @author piyush
 *
 */
@Service
public class CompanyServiceHelper {

	private final static Logger LOGGER = LoggerFactory.getLogger(CompanyServiceHelper.class);

	@Autowired
	private CompanyService companyService;

	@Autowired
	private FactoryService factoryService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BucketService bucketService;

	/**
	 * This service helper method is used for save company response mantainence.
	 * 
	 * @param companyForm  {@link CompanyForm}
	 * @param comppanyLogo
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO saveCompany(CompanyForm companyForm, MultipartFile companyLogo) {
		String fileName = null;
		if (Objects.nonNull(companyLogo) && !companyLogo.isEmpty()) {
			try {
				fileName = companyLogo.getResource().getFilename();
				bucketService.uploadImageToBucket(companyLogo.getResource().getFile());
			} catch (IOException ioException) {
				throw new ImageUploadException(ServiceMessageCode.UNABLE_TO_UPLOAD_COMPANY_IMAGE);
			}
		}
		Company company = null;
		User user = null;
		Factory factory = null;
		try {
			user = userService.saveUser(getUserByCompanyForm(companyForm));
		} catch (Exception exception) {
			bucketService.deleteImageFromBucket(fileName);
			exception.printStackTrace();
			LOGGER.error("unable to create company user {} ", companyForm.getUserName());
			throw new UserException(ServiceMessageCode.UNABLE_TO_CREATE_COMPANY_USER);
		}
		try {
			factory = factoryService.saveFactory(getFactoryByCompanyForm(companyForm));
		} catch (Exception e) {
			bucketService.deleteImageFromBucket(fileName);
			e.printStackTrace();
			LOGGER.error("unable to create factory {} ", companyForm.getName());
			throw new FactoryException(ServiceMessageCode.UNABLE_TO_CREATE_FACTORY);
		}
		try {
			company = companyService.saveCompany(getCompanyByCompanyForm(companyForm, user, fileName));
		} catch (Exception e) {
			bucketService.deleteImageFromBucket(fileName);
			e.printStackTrace();
			LOGGER.error("unable to create company {} ", companyForm.getName());
			throw new CompanyException(ServiceMessageCode.UNABLE_TO_CREATE_COMPANY);
		}
		try {
			Role adminRole = roleService.createAdminRole(company);
			roleService.createUserRole(company);
			user.setRole(adminRole);
			user.setUserType("ROLE_ADMIN");
			factory.setCompany(company);
			factoryService.saveFactory(factory);
			List<Factory> factories = user.getFactories();
			if (Objects.isNull(factories)) {
				factories = new ArrayList<Factory>();
			}
			factories.add(factory);
			user.setCompany(company);
			user.setFactories(factories);
			User savedUser = userService.saveUser(user);
			company.setUser(savedUser);
			companyService.saveCompany(company);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("unable to create company user role for user {} ", companyForm.getUserName());
			throw new CompanyException(ServiceMessageCode.UNABLE_TO_CREATE_COMPANY_USER_ROLES);
		}
		uploadCompanyLogo(company.getId(), companyLogo);
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.COMPANY_CREATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used for fetch list of {@link Company}
	 * 
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getCompanyList() {
		List<CompanyDTO> companyDTOs = companyService.getCompanyList();
		if (companyDTOs.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.NO_COMPANY_CREATED_YET, null, true,
					HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(companyDTOs,
				ServiceMessageCode.COMPANIES_LIST_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to de activate {@link Company}.
	 * 
	 * @param comapnyId id of company
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO deActivateCompany(Long comapnyId) {
		try {
			companyService.deActivateCompany(comapnyId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CompanyException(ServiceMessageCode.UNABLE_TO_DEACTIVATE_COMPANY);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.COMPANY_DEACTIVATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to activate {@link Company}
	 * 
	 * @param companyId id of company
	 * @param active    company status to be changed
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO setCompanyStatus(Long companyId, boolean active) {
		try {
			companyService.setCompanyStatus(companyId, active);
		} catch (Exception e) {
			throw new CompanyException(ServiceMessageCode.UNABLE_TO_SET_COMPANY_STATUS);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.COMPANY_STATUS_CHANGED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to delete {@link Company}
	 * 
	 * @param companyId id of company
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO deleteCompany(Long companyId) {
		try {
			companyService.deleteCompany(companyId);
		} catch (Exception e) {
			throw new CompanyException(ServiceMessageCode.UNABLE_TO_DELETE_COMPANY);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.COMPANY_DELETED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to activate {@link Company}
	 * 
	 * @param companyId id of company
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO activateCompany(Long companyId) {
		try {
			companyService.activateCompany(companyId);
		} catch (Exception e) {
			throw new CompanyException(ServiceMessageCode.UNABLE_TO_ACTIVATE_COMPANY);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.COMPANY_ACTIVATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to update {@link Company}
	 * 
	 * @param companyId   id of company
	 * @param companyForm {@link CompanyForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO updateCompany(UpdateCompanyForm companyForm, MultipartFile companyLogo) {
		String fileName = null;
		if (!companyLogo.isEmpty()) {
			try {
				fileName = companyLogo.getResource().getFilename();
				bucketService.uploadImageToBucket(companyLogo.getResource().getFile());
			} catch (IOException ioException) {
				throw new ImageUploadException(ServiceMessageCode.UNABLE_TO_UPLOAD_COMPANY_IMAGE);
			}
		}
		try {
			Company updatedCompany = companyService.saveCompany(getUpdatedCompanyByCompanyAndCompanyForm(
					companyService.getCompanyByCompanyId(companyForm.getCompanyId()), companyForm, fileName));
			User updatedUser = updatedCompany.getUser();
			updatedUser.setCompany(updatedCompany);
			userService.saveUser(updatedUser);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("unable to update company for company id {} ", companyForm.getCompanyId());
			throw new CompanyException(ServiceMessageCode.UNABLE_TO_UPDATE_COMPANY);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.COMPANY_UPDATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to get auto complate suggest {@link Company} with
	 * company name.
	 * 
	 * @param companyName name of company
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO autoCompleteCompany(String companyName) {
		List<CompanyDTO> companyList = companyService.autoCompleteCompany(companyName);
		if (companyList.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.NO_AUTO_COMPLETE_COMPANY_FOUND,
					null, true, HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(companyList,
				ServiceMessageCode.COMPANIES_LIST_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to set company details as per update.
	 * 
	 * @param company     {@link Company}
	 * @param companyForm {@link CompanyForm}
	 * @return {@link Company}
	 */
	private Company getUpdatedCompanyByCompanyAndCompanyForm(Company company, UpdateCompanyForm companyForm,
			String fileName) {
		User updateUser = getUpdatedUserByCompanyForm(company.getUser(), companyForm);
		Company updatedCompany = getCompanyByUpdatedCompanyForm(companyForm, updateUser, fileName);
		updatedCompany.setId(company.getId());
		updatedCompany.setName(company.getName());
		return updatedCompany;
	}

	/**
	 * This helper method is used to set user details as per update.
	 * 
	 * @param user        {@link User}
	 * @param companyForm {@link CompanyForm}
	 * @return {@link User}
	 */
	private User getUpdatedUserByCompanyForm(User user, UpdateCompanyForm companyForm) {
		User updatedUser = getUserByUpdatedCompanyForm(companyForm);
		updatedUser.setId(user.getId());
		return updatedUser;
	}

	/**
	 * This helper method is used for set factory details.
	 * 
	 * @param companyForm {@link CompanyForm}
	 * @return {@link Factory}
	 */
	private Factory getFactoryByCompanyForm(CompanyForm companyForm) {
		Factory factory = new Factory();
		factory.setActive(true);
		factory.setAddress(companyForm.getAddress());
		factory.setEmail(companyForm.getEmail());
		factory.setMobileNumber(companyForm.getMobileNumber());
		factory.setName(companyForm.getName());
		factory.setLicenseIssueDate(new Timestamp(new Date().getTime()));
		factory.setLicenseExpDate(new Timestamp(DateUtils.addMonths(new Date(), 1).getTime()));
		return factory;
	}

	/**
	 * This helper method is used for set comapny details.
	 * 
	 * @param companyForm {@link CompanyForm}
	 * @param user
	 * @param filePath
	 * @return {@link Company}
	 */
	private Company getCompanyByCompanyForm(CompanyForm companyForm, User user, String fileName) {
		Company company = new Company();
		company.setActive(true);
		company.setAddress(companyForm.getAddress());
		company.setEmail(companyForm.getEmail());
		company.setGstNumber(companyForm.getGstNumber());
		company.setLandLineNumber(companyForm.getLandLineNumber());
		company.setMobileNumber(companyForm.getMobileNumber());
		company.setName(companyForm.getName());
		company.setLastPay(companyForm.getLastPay());
		company.setCompanyHead(companyForm.getCompanyHead());
		company.setUser(user);
		company.setCreatedBy(GenericUtils.getLoggedInUser());
		company.setUpdatedBy(GenericUtils.getLoggedInUser());
		if (!StringUtils.isEmpty(fileName)) {
			Document document = new Document();
			document.setDocumentType(DocumentType.IMAGE);
			document.setS3BucketFileName(fileName);
			company.setDocument(document);
		}
		return company;
	}

	private Company getCompanyByUpdatedCompanyForm(UpdateCompanyForm companyForm, User user, String fileName) {
		Company company = new Company();
		company.setActive(true);
		company.setAddress(companyForm.getAddress());
		company.setEmail(companyForm.getEmail());
		company.setGstNumber(companyForm.getGstNumber());
		company.setLandLineNumber(companyForm.getLandLineNumber());
		company.setMobileNumber(companyForm.getMobileNumber());
		company.setLastPay(companyForm.getLastPay());
		company.setCompanyHead(companyForm.getCompanyHead());
		company.setUser(user);
		company.setCreatedBy(GenericUtils.getLoggedInUser());
		company.setUpdatedBy(GenericUtils.getLoggedInUser());
		if (!StringUtils.isEmpty(fileName)) {
			Document document = new Document();
			document.setDocumentType(DocumentType.IMAGE);
			document.setS3BucketFileName(fileName);
			company.setDocument(document);
		}
		return company;
	}

	/**
	 * This helper method is used to get {@link User} by {@link CompanyForm}. This
	 * method basically set the user object from the data as per
	 * {@link CompanyForm}.
	 * 
	 * @param companyForm {@link CompanyForm}
	 * @return {@link User}
	 */
	private User getUserByCompanyForm(CompanyForm companyForm) {
		User user = new User();
		user.setUsername(companyForm.getUserName());
		user.setEmail(companyForm.getEmail());
		user.setName(companyForm.getCompanyHead());
		user.setActive(true);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(companyForm.getPassword());
		user.setPassword(hashedPassword);
		user.setUserType("ROLE_ADMIN");
		return user;
	}

	private User getUserByUpdatedCompanyForm(UpdateCompanyForm companyForm) {
		User user = new User();
		user.setUsername(companyForm.getUserName());
		user.setEmail(companyForm.getEmail());
		user.setName(companyForm.getCompanyHead());
		user.setPassword(companyForm.getPassword());
		user.setActive(true);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		user.setUserType("ROLE_ADMIN");
		return user;
	}

	public ResponseDTO getCompanyByUser(Long userId) {
		CompanyDTO company = companyService.getCompanyByUser(userId);
		return ResponseHandler.generateServiceResponse(company, ServiceMessageCode.COMPANIES_LIST_FETCHED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

	public ResponseDTO uploadCompanyLogo(Long companyId, MultipartFile companyLogo) {
		Company company = companyService.getCompanyByCompanyId(companyId);
		try {
			String fileName = companyLogo.getResource().getFilename();
			String filePath = System.getProperty("user.dir") + "/" + fileName;
			File file = new File(filePath);
			LOGGER.info("File name is {} ", fileName);
			byte[] fileByte = companyLogo.getBytes();
			FileUtils.writeByteArrayToFile(file, fileByte);
			bucketService.uploadImageToBucket(file);
			Document document = company.getDocument();
			if (Objects.isNull(document)) {
				document = new Document();
			} else {
				document.setId(document.getId());
			}
			document.setDocumentType(DocumentType.IMAGE);
			document.setS3BucketFileName(fileName);
			company.setDocument(document);
			companyService.saveCompany(company);
			bucketService.getAllTheAccessControlListForImageBucket().forEach(grants -> {
				LOGGER.info("Granted Permissions are {} ", grants.getPermission());
			});
			bucketService.getAllImagesFromBucket().getObjectSummaries().forEach(objectSummary -> {
				LOGGER.info("File name is {} ", objectSummary.getKey());
				LOGGER.info("File size is {} ", objectSummary.getSize());
			});
			return ResponseHandler.generateServiceResponse(null,
					ServiceMessageCode.COMPANY_LOGO_HAS_BEEN_UPLOADED_SUCCESSFULLY, null, true, HttpStatus.OK);
		} catch (IOException ioException) {
			ioException.printStackTrace();
			throw new ImageUploadException(ServiceMessageCode.UNABLE_TO_UPLOAD_COMPANY_IMAGE);
		}
	}

}
