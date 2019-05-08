package com.prosmv.service.role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prosmv.domain.Company;
import com.prosmv.domain.Role;
import com.prosmv.repositories.RoleRepository;
import com.prosmv.util.GenericUtils;

/**
 * This service class is used to use role related servcices either find , create
 * etc.
 * 
 * @author piyush
 *
 */
@Service
public class RoleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleService.class);

	@Autowired
	private RoleRepository roleRepository;

	/**
	 * This service is used to create super admin {@link Role}.
	 * 
	 * @param company {@link Company}
	 * @return {@link Role}
	 */
	@Transactional(rollbackFor = Exception.class)
	public Role createSARole(Company company) {
		Role role = new Role();
		role.setCreatedBy(GenericUtils.getLoggedInUser());
		role.setRoleName("SuperAdmin");
		role.setCompany(company);
		return roleRepository.save(role);
	}

	/**
	 * This service is used to create user {@link Role}.
	 * 
	 * @param company {@link Company}
	 * @return {@link Role}
	 */
	@Transactional(rollbackFor = Exception.class)
	public Role createUserRole(Company company) {
		Role role = new Role();
		role.setCreatedBy(GenericUtils.getLoggedInUser());
		role.setRoleName("User");
		role.setCompany(company);
		return roleRepository.save(role);
	}

	/**
	 * This method is used to create admin {@link Role}.
	 * 
	 * @param company {@link Company}
	 * @return {@link Role}
	 */
	@Transactional(rollbackFor = Exception.class)
	public Role createAdminRole(Company company) {
		Role role = new Role();
		role.setCreatedBy(GenericUtils.getLoggedInUser());
		role.setRoleName("Admin");
		role.setCompany(company);
		return roleRepository.save(role);
	}

}
