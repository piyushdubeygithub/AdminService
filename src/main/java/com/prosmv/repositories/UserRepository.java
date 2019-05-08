package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prosmv.domain.Company;
import com.prosmv.domain.Factory;
import com.prosmv.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

	public User findById(Long userId);

	public User findByEmail(String email);

	public User findByUsername(String username);

	public List<User> findByCompany(Company company);

	public User findByUsernameAndFactories(String username, List<Factory> factories);

	public long countByCompany(Company company);

}
