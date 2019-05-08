package com.prosmv.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is used as DTO for autocomplete role api.
 * 
 * @author piyush
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public interface AutoCompleteRoleDTO {

	public Long getId();

	public String getRoleName();

}
