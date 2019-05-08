package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prosmv.domain.CustomerSupplier;
import com.prosmv.domain.Factory;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerSupplier, Serializable>{

	public CustomerSupplier findByName(String customerName);
	
	public CustomerSupplier findById(Long customerId);
	
	public CustomerSupplier findByNameAndFactory(String customerName, Factory factoy);

	public List<CustomerSupplier> findByFactory(Long factoryId);
}
