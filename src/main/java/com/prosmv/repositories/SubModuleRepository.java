package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prosmv.domain.Module;
import com.prosmv.domain.SubModule;

@Repository
public interface SubModuleRepository extends JpaRepository<SubModule, Serializable> {

	public SubModule findBySubModuleName(String subModuleName);
	public List<SubModule> findByModule(Module module);
}
