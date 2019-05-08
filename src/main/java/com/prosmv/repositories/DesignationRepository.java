package com.prosmv.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prosmv.domain.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Serializable> {

	public Designation findByDesignationname(String designationName);

	public Designation findById(Long designationId);

}
