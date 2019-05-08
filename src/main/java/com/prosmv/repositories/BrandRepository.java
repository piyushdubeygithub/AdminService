package com.prosmv.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prosmv.domain.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Serializable>{

	public Brand findByName(String brandName);
	public Brand findById(Long brandId);
}
