package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prosmv.domain.Company;
import com.prosmv.domain.Factory;
import com.prosmv.dto.AutoCompleteFactoryDTO;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Serializable> {

	public Factory findByName(String name);

	public Factory findById(Long id);

	public Factory findByNameAndCompany(String name, Company company);

	public long countByCompany(Company company);

	public List<Factory> findByCompany(Company company);

	public Factory findTop1ByCompanyOrderByLicenseIssueDateDesc(Company company);
	
	public List<Factory> findByCompanyOrderByLicenseIssueDateDesc(Company company);


	public List<AutoCompleteFactoryDTO> findByNameIgnoreCaseContaining(String factoryName);
}
