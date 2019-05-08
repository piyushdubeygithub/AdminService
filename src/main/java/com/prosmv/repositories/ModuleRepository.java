package com.prosmv.repositories;

import com.prosmv.domain.Module;

public interface ModuleRepository extends SubModuleRepository{
	
	public Module findById(Long id);

}
