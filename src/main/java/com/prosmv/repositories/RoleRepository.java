package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prosmv.domain.Company;
import com.prosmv.domain.Role;
import com.prosmv.dto.AutoCompleteRoleDTO;

@Repository
public interface RoleRepository extends JpaRepository<Role, Serializable> {
	public Role findByRoleNameAndCompany(String rolename, Company company);

	public Role findById(Long id);

	public List<Role> findByCompany(Company company);

	public List<AutoCompleteRoleDTO> findByRoleNameIgnoreCaseContaining(String roleName);

	public List<AutoCompleteRoleDTO> findByRoleNameIgnoreCaseContainingAndCompanyId(String roleName, Long companyId);
}
