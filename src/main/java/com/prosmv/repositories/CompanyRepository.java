package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.prosmv.domain.Company;
import com.prosmv.domain.User;
import com.prosmv.dto.CompanyDTO;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Serializable>{
	
	public Company findById(Long id);
	public Company findByName(String name);
	public List<Company> findAllByOrderByNameAsc();

	 @Query(value = "select new com.prosmv.dto.CompanyDTO(c.id,c.name, c.isActive,c.deleted)"
		 		+ " from  Company c "
		 		+ " where "
		 		+ "lower(c.name) like :name% ")
    public List<CompanyDTO> findByCompanyName(@Param(value = "name") String name);
	public Company findByEmail(String email);
	public Company findByUser(User user);
}
