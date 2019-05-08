package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prosmv.domain.Factory;
import com.prosmv.domain.StitchClass;

public interface StitchClassRepository extends JpaRepository<StitchClass, Serializable>{

	public StitchClass findByNameAndFactory(String name, Factory factory);
	public List<StitchClass> findByFactory(Factory factory);

}
