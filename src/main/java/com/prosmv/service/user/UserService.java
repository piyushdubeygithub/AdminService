package com.prosmv.service.user;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.prosmv.domain.Company;
import com.prosmv.domain.Factory;
import com.prosmv.domain.Role;
import com.prosmv.domain.User;
import com.prosmv.dto.CompanyDTO;
import com.prosmv.dto.UserDTO;
import com.prosmv.form.UpdateUserForm;
import com.prosmv.form.UserForm;
import com.prosmv.repositories.CompanyRepository;
import com.prosmv.repositories.FactoryRepository;
import com.prosmv.repositories.RoleRepository;
import com.prosmv.repositories.UserRepository;
import com.prosmv.service.company.CompanyService;
import com.prosmv.util.GenericUtils;

/**
 * This service class is used for accessing all the services realted to
 * {@link User}.
 * 
 * @author piyush
 *
 */
@Service
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private FactoryRepository factoryRepository;

	@Autowired
	private CompanyService companyService;
	
	/**
	 * This service will be used to save {@link User}.
	 * 
	 * @param user {@link User}
	 */
	@Transactional(rollbackFor = Exception.class)
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User getUser(UserForm userForm) {
		User user = new User();
		Company company = null;
		company = companyRepository.findById(userForm.getCompanyId());
		List<Factory> factories = new ArrayList<>();
		if (userForm.getFactoryNames() != null) {
			List<String> factoryNames = userForm.getFactoryNames();
			for (String factoryName : factoryNames) {
				Factory factory = factoryRepository.findByName(factoryName);
				factories.add(factory);
			}
			user.setFactories(factories);
		}
		user.setCompany(company);
		user.setUsername(userForm.getUsername());
		user.setActive(true);
		user.setDeleted('N');
		user.setEmail(userForm.getEmail());
		user.setName(userForm.getName());
		user.setMobileNumber(userForm.getMobileNumber());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(userForm.getPassword());
		user.setPassword(hashedPassword);
		Role role = roleRepository.findById(userForm.getRoleId());
		user.setRole(role);
		if (role.getRoleName().toLowerCase().contains("admin")) {
			user.setUserType("ROLE_ADMIN");
		} else if (role.getRoleName().toLowerCase().contains("superadmin")) {
			user.setUserType("ROLE_SUPERADMIN");
		} else {
			user.setUserType("ROLE_USER");
		}
		return user;
	}

	public User getUser(UpdateUserForm userForm) {
		User user = new User();
		Company company = null;
		company = companyRepository.findById(userForm.getCompanyId());
		List<Factory> factories = new ArrayList<>();
		if (userForm.getFactoryNames() != null) {
			List<String> factoryNames = userForm.getFactoryNames();
			for (String factoryName : factoryNames) {
				Factory factory = factoryRepository.findByName(factoryName);
				factories.add(factory);
			}
			user.setFactories(factories);
		}
		user.setCompany(company);
		user.setUsername(userForm.getUsername());
		user.setActive(true);
		user.setEmail(userForm.getEmail());
		user.setName(userForm.getName());
		user.setMobileNumber(userForm.getMobileNumber());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(userForm.getPassword());
		user.setPassword(hashedPassword);
		Role role = roleRepository.findById(userForm.getRoleId());
		user.setRole(role);
		if (role.getRoleName().toLowerCase().contains("admin")) {
			user.setUserType("ROLE_ADMIN");
		} else if (role.getRoleName().toLowerCase().contains("superadmin")) {
			user.setUserType("ROLE_SUPERADMIN");
		} else {
			user.setUserType("ROLE_USER");
		}
		return user;
	}
	
	public boolean isUserExists(UserForm userForm) {
		boolean userExists = false;
		User oldUser = userRepository.findByUsername(userForm.getUsername());
		if (oldUser != null) {
			userExists = true;
		}
		return userExists;
	}

	public String updateUser(UpdateUserForm userForm) {
		String response = null;
		User oldUser = userRepository.findById(userForm.getUserId());
		if (oldUser != null) {
			User user = getUser(userForm);
			user.setId(oldUser.getId());
			userRepository.save(user);
			response = "user updated";
		} else {
			response = "user not found";
		}
		return response;
	}

	/**
	 * This service will be used to get all {@link User} by {@link Company} id.
	 * 
	 * @param companyId id of {@link Company}
	 * @return {@link List} of {@link UserDTO}
	 */
	public List<UserDTO> getUserList(Long companyId) {
		List<UserDTO> userList = new ArrayList<>();
		Company company = companyRepository.findById(companyId);
		List<User> users = userRepository.findByCompany(company);
		for (User user : users) {
			if (user.getDeleted() != 'Y' && user.isActive() && !user.equals(GenericUtils.getLoggedInUser())) {
				UserDTO userDTO = new UserDTO(user);
				CompanyDTO companyDTO = new CompanyDTO(company, companyService.getCompanyLogo(company));
				userDTO.setCompanyDTO(companyDTO);
				userList.add(userDTO);
			}
		}
		return userList;
	}

	/**
	 * This service will be used to deactivate {@link User}.
	 * 
	 * @param userId id of {@link User}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deActivateUser(Long userId) {
		User user = userRepository.findById(userId);
		user.setActive(false);
		saveUser(user);
	}

	/**
	 * This service will be used to activate {@link User}.
	 * 
	 * @param userId id of {@link User}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void activateUser(Long userId) {
		User user = userRepository.findById(userId);
		user.setActive(true);
		saveUser(user);
	}

	/**
	 * This service will be used to set status of {@link User}.
	 * 
	 * @param userId id of {@link User}
	 * @param active {@code true} or {@code false}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void setUserStatus(Long userId, boolean active) {
		User user = userRepository.findById(userId);
		user.setActive(active);
		saveUser(user);
	}

	/**
	 * This service will be used to get all {@link User}.
	 * 
	 * @return {@link List} of {@link UserDTO}
	 */
	public List<UserDTO> getUsers() {
		List<UserDTO> userList = new ArrayList<>();
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if (user.isActive()) {
				if(user.getDeleted() != null && user.getDeleted()=='Y') {
					continue;
				}
				UserDTO userDTO = new UserDTO(user);
				userList.add(userDTO);
			}
		}
		return userList;
	}

	/**
	 * This service will be used to delete {@link User}.
	 * 
	 * @param userId id of {@link User}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteUser(Long userId) {
		User user = getUserById(userId);
		user.setDeleted('Y');
		saveUser(user);
	}

	/**
	 * This service will be used to get {@link User} by user id
	 * 
	 * @param userId id of {@link User}
	 * @return {@link User}
	 */
	public User getUserById(Long userId) {
		return userRepository.findById(userId);
	}



}
