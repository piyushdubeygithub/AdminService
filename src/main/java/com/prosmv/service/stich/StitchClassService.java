package com.prosmv.service.stich;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosmv.domain.Factory;
import com.prosmv.domain.StitchClass;
import com.prosmv.dto.StitchClassListDTO;
import com.prosmv.form.StitchClassForm;
import com.prosmv.repositories.FactoryRepository;
import com.prosmv.repositories.StitchClassRepository;

/**
 * This service class is used for accessing the services related to
 * {@link StitchClass}.
 * 
 * @author piyush
 *
 */
@Service
public class StitchClassService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StitchClassService.class);

	@Autowired
	private StitchClassRepository stitchClassRepository;

	@Autowired
	private FactoryRepository factoryRepository;

	public String saveStitchClass(StitchClassForm stitchClassForm) {
		String response = null;
		if (!isStitchClassExists(stitchClassForm)) {
			StitchClass stitchClass = getStitchClass(stitchClassForm);
			stitchClassRepository.save(stitchClass);
			response = "stitch class is created successfully";
		} else {
			response = "stitchClass already exists";
		}
		return response;
	}

	public StitchClass getStitchClass(StitchClassForm stitchClassForm) {
		StitchClass stitchClass = new StitchClass();
		stitchClass.setActive(true);
		stitchClass.setName(stitchClassForm.getStitchClass());
		if (stitchClassForm.getDescription() != null) {
			stitchClass.setDescription(stitchClassForm.getDescription());
		}
		if (stitchClassForm.getFactoryName() != null) {
			Factory factory = factoryRepository.findByName(stitchClassForm.getFactoryName());
			stitchClass.setFactory(factory);
		}
		stitchClass.setLooperThread(stitchClassForm.getLooperThread());
		stitchClass.setThreadRatio(stitchClassForm.getThreadRatio());
		if (stitchClassForm.getMachineType() != null) {
			stitchClass.setMachineType(stitchClassForm.getMachineType());
		}
		stitchClass.setNeedleCount(stitchClassForm.getNeedleCount());
		stitchClass.setNeedleThread(stitchClassForm.getNeedleThread());
		return stitchClass;
	}

	private boolean isStitchClassExists(StitchClassForm stitchClassForm) {
		boolean stitchClassExists = false;
		Factory factory = factoryRepository.findByName(stitchClassForm.getFactoryName());
		StitchClass stitchClass = stitchClassRepository.findByNameAndFactory(stitchClassForm.getStitchClass(), factory);
		if (stitchClass != null) {
			stitchClassExists = true;
		}
		return stitchClassExists;
	}

	public String updateStitchClass(@Valid StitchClassForm stitchClassForm) {
		String response = null;
		Factory factory = factoryRepository.findByName(stitchClassForm.getFactoryName());
		StitchClass oldStitchClass = stitchClassRepository.findByNameAndFactory(stitchClassForm.getStitchClass(),
				factory);
		if (oldStitchClass != null) {
			StitchClass stitchClass = getStitchClass(stitchClassForm);
			stitchClass.setId(oldStitchClass.getId());
			stitchClassRepository.save(stitchClass);
			response = "company is updated";
		} else {
			response = "company not found";
		}
		return response;
	}

	public StitchClassListDTO getStitchClasses(String factoryName) {
		Factory factory = factoryRepository.findByName(factoryName);
		List<StitchClass> stitchClasses = stitchClassRepository.findByFactory(factory);
		List<StitchClass> stitchClassList = new ArrayList<>();
		for (StitchClass stitchClass : stitchClasses) {
			if (!stitchClass.isDeleted()) {
				stitchClassList.add(stitchClass);
			}
		}
		return new StitchClassListDTO(stitchClassList);
	}

	public String deleteStitchClass(String stitchClassName, String factoryName) {
		Factory factory = factoryRepository.findByName(factoryName);
		StitchClass stitchClass = stitchClassRepository.findByNameAndFactory(stitchClassName, factory);
		stitchClass.setDeleted(true);
		stitchClassRepository.save(stitchClass);
		return "stitchclass deleted successfully";
	}

}
