package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prosmv.domain.Factory;
import com.prosmv.domain.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Serializable>{

	public Machine findByNameAndFactory(String machineName, Factory factory);
	public List<Machine> findByFactory(Factory factory);
}
