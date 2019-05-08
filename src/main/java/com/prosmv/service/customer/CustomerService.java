package com.prosmv.service.customer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prosmv.domain.Brand;
import com.prosmv.domain.CustomerSupplier;
import com.prosmv.domain.Factory;
import com.prosmv.dto.BrandDTO;
import com.prosmv.dto.CustomerDTO;
import com.prosmv.form.CustomerForm;
import com.prosmv.repositories.BrandRepository;
import com.prosmv.repositories.CompanyRepository;
import com.prosmv.repositories.CustomerRepository;
import com.prosmv.repositories.FactoryRepository;
import com.prosmv.util.GenericUtils;

/**
 * This service class is used for accessing all the services related to
 * {@link CustomerSupplier}
 * 
 * @author piyush
 *
 */
@Service
public class CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FactoryRepository factoryRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private BrandRepository brandRepository;

	public String saveCustomer(CustomerForm customerForm) {
		String response = null;
		if (!isCustomerExists(customerForm)) {
			CustomerSupplier customerSupplier = getCustomerSupplier(customerForm);
			if (customerSupplier == null) {
				response = "factory is required";
			} else {
				customerRepository.save(customerSupplier);
				response = "customer created successfully";
			}
		} else {
			response = "customer already exists";
		}
		return response;
	}

	private CustomerSupplier getCustomerSupplier(CustomerForm customerForm) {
		CustomerSupplier customerSupplier = new CustomerSupplier();
		customerSupplier.setName(customerForm.getCustomerName());
		Factory factory = null;
		if (customerForm.getFactoryId() != null) {
			factory = factoryRepository.findById(customerForm.getFactoryId());
			customerSupplier.setFactory(factory);
		}
		if (factory == null) {
			return null;
		}
		if (customerForm.getAddress() != null) {
			customerSupplier.setAddress(customerForm.getAddress());
		}
		if (customerForm.getCustomerType() != null) {
			customerSupplier.setCustomerType(customerForm.getCustomerType());
		}
		if (customerForm.getEmail() != null) {
			customerSupplier.setEmail(customerForm.getEmail());
		}
		if (customerForm.getMobileNumber() != null) {
			customerSupplier.setMobileNumber(customerForm.getMobileNumber());
		}
		customerSupplier.setActive(true);
		customerSupplier.setDeleted(false);
		return customerSupplier;
	}

	private boolean isCustomerExists(CustomerForm customerForm) {
		boolean customerExists = false;
		Factory factory = factoryRepository.findById(customerForm.getFactoryId());
		CustomerSupplier customerSupplier = customerRepository.findByNameAndFactory(customerForm.getCustomerName(),
				factory);
		if (customerSupplier != null) {
			customerExists = true;
		}
		return customerExists;
	}

	public String updateCustomer(CustomerForm customerForm) {
		String response = null;
		Factory factory = factoryRepository.findById(customerForm.getFactoryId());
		CustomerSupplier oldCustomer = customerRepository.findByNameAndFactory(customerForm.getCustomerName(), factory);
		if (oldCustomer != null) {
			CustomerSupplier customer = getCustomerSupplier(customerForm);
			if (customer != null) {
				customer.setId(oldCustomer.getId());
				customerRepository.save(customer);
				response = "customer is updated";
			} else {
				response = "company is required";
			}
		} else {
			response = "customer not found";
		}
		return response;
	}

	/**
	 * This service is used to add {@link Brand}
	 * 
	 * @param customerId id of {@link CustomerSupplier}
	 * @param brandName  name of new {@link Brand}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void addBrand(Long customerId, String brandName) {
		CustomerSupplier customerSupplier = customerRepository.findById(customerId);
		List<Brand> brands = customerSupplier.getBrands();
		Brand brand = new Brand();
		brand.setName(brandName);
		brand.setCustomer(customerSupplier);
		brand.setCreatedBy(GenericUtils.getLoggedInUser());
		brand.setUpdatedBy(GenericUtils.getLoggedInUser());
		brand = brandRepository.save(brand);
		brands.add(brand);
		customerSupplier.setBrands(brands);
		customerRepository.save(customerSupplier);
	}

	/**
	 * This service is used to de activate {@link CustomerSupplier}
	 * 
	 * @param customerId id of {@link CustomerSupplier}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deActivateCustomer(Long customerId) {
		CustomerSupplier customerSupplier = getCustomerByCustomerId(customerId);
		customerSupplier.setActive(false);
		customerRepository.save(customerSupplier);
	}

	/**
	 * This service is used to activate {@link CustomerSupplier}
	 * 
	 * @param customerId is of {@link CustomerSupplier}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void activateCustomer(Long customerId) {
		CustomerSupplier customerSupplier = getCustomerByCustomerId(customerId);
		customerSupplier.setActive(true);
		customerRepository.save(customerSupplier);
	}

	/**
	 * This service is used to get all {@link Brand}
	 * 
	 * @param customerId id of {@link CustomerSupplier}
	 * @return {@link List} of {@link BrandDTO}
	 */
	public List<BrandDTO> getAllBrands(Long customerId) {
		CustomerSupplier customerSupplier = getCustomerByCustomerId(customerId);
		List<BrandDTO> validBrands = new ArrayList<>();
		if (customerSupplier != null) {
			List<Brand> brands = customerSupplier.getBrands();
			for (Brand brand : brands) {
				if (!brand.isDeleted()) {
					validBrands.add(new BrandDTO(brand));
				}
			}
		}
		return validBrands;
	}

	/**
	 * This service is used to delete {@link Brand}
	 * 
	 * @param brandId id of {@link Brand}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteBrand(Long brandId) {
		Brand brand = getBrandByBrandId(brandId);
		brand.setDeleted(true);
		brandRepository.save(brand);
	}

	/**
	 * This service is used to get {@link Brand} by brand id
	 * 
	 * @param brandId id of {@link Brand}
	 * @return {@link Brand}
	 */
	public Brand getBrandByBrandId(Long brandId) {
		return brandRepository.findById(brandId);
	}

	/**
	 * This service is used to get {@link CustomerSupplier} by customer id.
	 * 
	 * @param customerId id of {@link CustomerSupplier}
	 * @return {@link CustomerSupplier}
	 */
	public CustomerSupplier getCustomerByCustomerId(Long customerId) {
		return customerRepository.findById(customerId);
	}

	public List<CustomerSupplier> getCustomersByFactoryId(Long factoryId) {
		return customerRepository.findByFactory(factoryId);
	}

	public List<CustomerDTO> getcustomers(Long factoryId) {
		List<CustomerSupplier> customers = getCustomersByFactoryId(factoryId);
		List<CustomerDTO> validCustomers = new ArrayList<>();
		for(CustomerSupplier customer:customers) {
			if(!customer.isDeleted()) {
				validCustomers.add(new CustomerDTO(customer));
			}
		}
		return validCustomers;
	}

}
