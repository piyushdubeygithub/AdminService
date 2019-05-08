package com.prosmv.service.factory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prosmv.constants.enums.FactoryMemberShip;
import com.prosmv.constants.message.ServiceMessageCode;
import com.prosmv.domain.Company;
import com.prosmv.domain.Factory;
import com.prosmv.domain.User;
import com.prosmv.dto.AutoCompleteFactoryDTO;
import com.prosmv.dto.CompanyDTO;
import com.prosmv.dto.FactoryDTO;
import com.prosmv.exception.FactoryException;
import com.prosmv.form.FactoryForm;
import com.prosmv.form.UpdateFactoryForm;
import com.prosmv.repositories.CompanyRepository;
import com.prosmv.repositories.FactoryRepository;
import com.prosmv.repositories.UserRepository;
import com.prosmv.service.company.CompanyService;

/**
 * This service class is used for accessing all the services related to
 * {@link Factory}.
 * 
 * @author piyush
 *
 */
@Service
public class FactoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FactoryService.class);

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private FactoryRepository factoryRepository;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * This service will be used to create {@link Factory}.
	 * 
	 * @param factory
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public Factory saveFactory(Factory factory) {
		return factoryRepository.save(factory);
	}

	public String saveFactory(FactoryForm factoryForm) {
		String response = null;
		if (!isFactoryExists(factoryForm)) {
			Factory factory = getFactory(factoryForm);
			if (factory == null) {
				response = "company does not exists";
			}
			factory.setActive(true);
			factory = factoryRepository.save(factory);
			if (factory != null) {
				response = "factory created successfully";
			} else {
				response = null;
			}
		} else {
			response = "factory already exists";
		}
		return response;
	}

	public boolean isFactoryExists(FactoryForm factoryform) {
		boolean factoryExists = false;
		Company company = companyRepository.findById(factoryform.getCompanyId());
		Factory oldFactory = factoryRepository.findByNameAndCompany(factoryform.getName(), company);
		if (oldFactory != null) {
			factoryExists = true;
		}
		return factoryExists;
	}

	private Factory getFactory(FactoryForm factoryForm) {
		Factory factory = new Factory();
		Company company = companyRepository.findById(factoryForm.getCompanyId());
		if (company != null) {
			factory.setCompany(company);
		} else {
			return null;
		}
		factory.setActive(true);
		factory.setAddress(factoryForm.getAddress());
		factory.setEmail(factoryForm.getEmail());
		factory.setMembership(factoryForm.getMembership());
		factory.setMobileNumber(factoryForm.getMobileNumber());
		if (factory.getMembership().equals(FactoryMemberShip.TRIAL)) {
			factory.setLicenseIssueDate(new Timestamp(new Date().getTime()));
			factory.setLicenseExpDate(new Timestamp(DateUtils.addMonths(new Date(), 1).getTime()));
		}
		if (factory.getLicenseExpDate() != null && factory.getLicenseIssueDate() != null) {
			factory.setLicenseIssueDate(factoryForm.getLicenseIssueDate());
			factory.setLicenseExpDate(factoryForm.getLicenseExpDate());
		}
		factory.setName(factoryForm.getName());
		return factory;
	}

	private Factory getFactory(UpdateFactoryForm factoryForm) {
		Factory factory = new Factory();
		Company company = companyRepository.findById(factoryForm.getCompanyId());
		if (company != null) {
			factory.setCompany(company);
		} else {
			return null;
		}
		factory.setActive(true);
		factory.setAddress(factoryForm.getAddress());
		factory.setEmail(factoryForm.getEmail());
		factory.setMembership(factoryForm.getMembership());
		factory.setMobileNumber(factoryForm.getMobileNumber());
		factory.setLicenseIssueDate(factoryForm.getLicenseIssueDate());
		factory.setLicenseExpDate(factoryForm.getLicenseExpDate());
		return factory;
	}

	public String updateFactory(UpdateFactoryForm factoryForm) {
		String response = null;
		Factory factory = getFactory(factoryForm);
		Factory oldFactory = factoryRepository.findById(factoryForm.getFactoryId());
		if (oldFactory != null) {
			factory.setId(oldFactory.getId());
			factory.setName(oldFactory.getName());
			factoryRepository.save(factory);
			response = "factory updated successfully";
		} else {
			throw new FactoryException(ServiceMessageCode.UNABLE_TO_UPDATE_FACTORY);
		}
		return response;
	}

	public List<FactoryDTO> getFactoryList() {
		List<FactoryDTO> factoryList = new ArrayList<>();
		List<Factory> factories = factoryRepository.findAll();
		for (Factory factory : factories) {
			if (!factory.isDeleted()) {
				Company company= factory.getCompany();
				CompanyDTO companyDTO= null;
				if(company != null && !company.isDeleted()) {
					companyDTO = new CompanyDTO(company,companyService.getCompanyLogo(company));
				}
				FactoryDTO factoryDTO = new FactoryDTO(factory, companyDTO);
				factoryList.add(factoryDTO);
			}
		}
		return factoryList;
	}

	/**
	 * This service will be used to de activate {@link Factory}.
	 * 
	 * @param factoryId
	 *            id of {@link Factory}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deActivateFactory(Long factoryId) {
		Factory factory = factoryRepository.findById(factoryId);
		factory.setActive(false);
		saveFactory(factory);
	}

	/**
	 * This service will be used to activate {@link Factory}.
	 * 
	 * @param factoryId
	 *            id of {@link Factory}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void activateFactory(Long factoryId) {
		Factory factory = factoryRepository.findById(factoryId);
		factory.setActive(true);
		saveFactory(factory);
	}

	/**
	 * This service will be used to delete {@link Factory}.
	 * 
	 * @param factoryId
	 *            id of {@link Factory}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteFactory(Long factoryId) {
		Factory factory = factoryRepository.findById(factoryId);
		factory.setDeleted(true);
		saveFactory(factory);
	}

	/**
	 * This service will be used to set {@link Factory} status.
	 * 
	 * @param factoryId
	 *            id of {@link Factory}
	 * @param isActive
	 *            either {@code true} or {@code false}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void setFactoryStatus(Long factoryId, boolean isActive) {
		Factory factory = factoryRepository.findById(factoryId);
		factory.setActive(isActive);
		saveFactory(factory);
	}

	/**
	 * This service will be used to get auto complete factory by name.
	 * 
	 * @param factoryName name of {@link Factory}
	 * @return {@link List} of {@link AutoCompleteFactoryDTO}
	 */
	public List<AutoCompleteFactoryDTO> getAutoCompleteFactory(String factoryName) {
		return factoryRepository.findByNameIgnoreCaseContaining(factoryName);
	}
	
	public List<FactoryDTO> getFactoryListByCompany(Long companyId) {
		List<FactoryDTO> factoryList = new ArrayList<>();
		List<Factory> factories = factoryRepository.findByCompany(companyService.getCompanyByCompanyId(companyId));
		for (Factory factory : factories) {
			if (!factory.isDeleted()) {
				Company company = factory.getCompany();
				CompanyDTO companyDTO = new CompanyDTO(company, companyService.getCompanyLogo(company));
				FactoryDTO factoryDTO = new FactoryDTO(factory, companyDTO);
				factoryList.add(factoryDTO);
			}
		}
		return factoryList;
	}

	public CompanyDTO getCompanyByFactory(Long factoryId) {
		Factory factory = factoryRepository.findById(factoryId);
		Company company=factory.getCompany();
		return new CompanyDTO(company,companyService.getCompanyLogo(company));
	}

}
