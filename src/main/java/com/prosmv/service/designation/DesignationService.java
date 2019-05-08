package com.prosmv.service.designation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prosmv.domain.Company;
import com.prosmv.domain.Designation;
import com.prosmv.dto.DesignationDTO;
import com.prosmv.form.DesignationForm;
import com.prosmv.repositories.CompanyRepository;
import com.prosmv.repositories.DesignationRepository;
import com.prosmv.util.GenericUtils;

/**
 * This class is used for accessing all the services related to
 * {@link Designation}.
 * 
 * @author piyush
 *
 */
@Service
public class DesignationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DesignationService.class);

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private DesignationRepository designationRepository;

	public String createDesignation(DesignationForm designationForm) {
		String response = null;
		if (!isExistsDesignation(designationForm)) {
			Designation designation = getDesignation(designationForm);
			designationRepository.save(designation);
			response = "designation created successfully";
		} else {
			response = "this designation already exists";
		}
		return response;
	}

	private Designation getDesignation(DesignationForm designationForm) {
		Designation designation = new Designation();
		designation.setDesignationname(designationForm.getDesignationname());
		designation.setContigencyAllowance(designationForm.getContigencyAllowance());
		designation.setPersonelAllowance(designationForm.getPersonelAllowance());
		Company company = companyRepository.findById(designationForm.getCompanyId());
		designation.setCompany(company);
		designation.setCreatedBy(GenericUtils.getLoggedInUser());
		return designation;
	}

	private boolean isExistsDesignation(DesignationForm designationForm) {
		boolean isDesignationExists = false;
		Designation designation = designationRepository.findByDesignationname(designationForm.getDesignationname());
		if (designation != null) {
			isDesignationExists = true;
		}
		return isDesignationExists;
	}

	public String updateDesignation(DesignationForm designationForm) {
		String response = null;
		Designation oldDesignation = designationRepository.findByDesignationname(designationForm.getDesignationname());
		if (oldDesignation != null) {
			Designation designation = getDesignation(designationForm);
			designation.setId(oldDesignation.getId());
			response = "designation updated successfully";
		} else {
			response = "designation not found";
		}
		return response;
	}

	/**
	 * This service will be used to delete {@link Designation}.
	 * 
	 * @param designationId id of {@link Designation}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteDesignation(Long designationId) {
		Designation designation = designationRepository.findById(designationId);
		designation.setDeleted(true);
		designationRepository.save(designation);
	}

	/**
	 * This service will be used to get all {@link Designation}.
	 * 
	 * @return {@link List} of {@link DesignationDTO}
	 */
	public List<DesignationDTO> getAllDesignations() {
		List<Designation> designationList = designationRepository.findAll();
		List<DesignationDTO> designationDTOs = new ArrayList<>();
		for (Designation designation : designationList) {
			if (!designation.isDeleted()) {
				DesignationDTO designationDTO = new DesignationDTO(designation);
				designationDTOs.add(designationDTO);
			}
		}
		return designationDTOs;
	}

}
