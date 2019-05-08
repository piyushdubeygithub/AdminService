package com.prosmv.service.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prosmv.domain.Company;
import com.prosmv.domain.Document;
import com.prosmv.domain.Factory;
import com.prosmv.domain.User;
import com.prosmv.dto.CompanyDTO;
import com.prosmv.repositories.CompanyRepository;
import com.prosmv.repositories.FactoryRepository;
import com.prosmv.repositories.UserRepository;
import com.prosmv.service.aws.BucketService;

/**
 * This service class is used for accessing all company services.
 * 
 * @author piyush
 *
 */
@Service
public class CompanyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FactoryRepository factoryRepository;

	@Autowired
	private BucketService bucketService;

	@Value("${aws.download.local.path}")
	private String awsFileDownloadLocalPath;

	/**
	 * This method is used to create company
	 * 
	 * @param company {@link Company}
	 * @return {@link Company}
	 */
	@Transactional(rollbackFor = Exception.class)
	public Company saveCompany(Company company) {
		return companyRepository.save(company);
	}

	/**
	 * This method is used to get all companies.
	 * 
	 * @return {@link List} of {@link CompanyDTO}
	 */
	public List<CompanyDTO> getCompanyList() {
		List<CompanyDTO> companyList = new ArrayList<>();
		List<Company> companies = companyRepository.findAllByOrderByNameAsc();
		for (Company company : companies) {
			if (!company.isDeleted()) {
				byte[] companyLogo = getCompanyLogo(company);
				CompanyDTO companyDTO = new CompanyDTO(company, companyLogo);
				long userCount = userRepository.countByCompany(company);
				long factoryCount = factoryRepository.countByCompany(company);
				companyDTO.setUserCount(userCount);
				companyDTO.setFactoryCount(factoryCount);
				Factory factory = factoryRepository.findTop1ByCompanyOrderByLicenseIssueDateDesc(company);
				if (factory != null && factory.getLicenseIssueDate() != null) {
					companyDTO.setLastPay(factory.getLicenseIssueDate());
				}
				companyList.add(companyDTO);
			}
		}
		return companyList;
	}

	/**
	 * This method is used to get company logo byte.
	 * 
	 * @param company
	 * @return
	 */
	public byte[] getCompanyLogo(Company company) {
		Document document = company.getDocument();
		if (Objects.nonNull(document)) {
			String fileName = document.getS3BucketFileName();
			bucketService.getImageFromBucket(fileName);
			return (awsFileDownloadLocalPath + fileName).getBytes();
		}
		return null;
	}

	/**
	 * This method is used to de activate the {@link Company}.
	 * 
	 * @param comapnyId id of company
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deActivateCompany(Long comapnyId) {
		Company company = companyRepository.findById(comapnyId);
		company.setActive(false);
		saveCompany(company);
	}


	/**
	 * This service will be used to activate {@link Company}
	 * 
	 * @param companyId id of company
	 */
	@Transactional(rollbackFor = Exception.class)
	public void activateCompany(Long companyId) {
		Company company = getCompanyByCompanyId(companyId);
		company.setActive(true);
		saveCompany(company);
	}

	/**
	 * This service will be used to get the {@link Company}
	 * 
	 * @param companyId id of company
	 * @return {@link Company}
	 */
	@Transactional(rollbackFor = Exception.class)
	public Company getCompanyByCompanyId(Long companyId) {
		return companyRepository.findById(companyId);
	}

	/**
	 * This service will be used to delete the {@link Company}
	 * 
	 * @param companyId id of company
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteCompany(Long companyId) {
		Company company = getCompanyByCompanyId(companyId);
		company.setDeleted(true);
		saveCompany(company);
		List<User> users = userRepository.findByCompany(company);
		for (User user : users) {
			user.setDeleted('Y');
		}
		List<Factory> factories = factoryRepository.findByCompany(company);
		for (Factory factory : factories) {
			factory.setDeleted(true);
		}
	}

	/**
	 * This service will be used to set company status.
	 * 
	 * @param companyId id of company
	 * @param active    status of company
	 */
	@Transactional(rollbackFor = Exception.class)
	public void setCompanyStatus(Long companyId, boolean active) {
		Company company = getCompanyByCompanyId(companyId);
		company.setActive(active);
		saveCompany(company);
		List<User> users = userRepository.findByCompany(company);
		for (User user : users) {
			user.setActive(active);;
		}
		List<Factory> factories = factoryRepository.findByCompany(company);
		for (Factory factory : factories) {
			factory.setActive(active);
		}
	}

	/**
	 * This service will be used to get auto complete company details as per company
	 * name.
	 * 
	 * @param name company name
	 * @return
	 */
	public List<CompanyDTO> autoCompleteCompany(String name) {
		List<CompanyDTO> companyList = companyRepository.findByCompanyName(name.toLowerCase());
		return companyList;
	}

	public CompanyDTO getCompanyByUser(Long userId) {
		Company company = companyRepository.findByUser(userRepository.findById(userId));
		return new CompanyDTO(company, getCompanyLogo(company));
	}

}
