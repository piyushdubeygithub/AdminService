package com.prosmv.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is used as DTO for autocomplete factory api.
 * 
 * @author piyush
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public interface AutoCompleteFactoryDTO {

	public Long getId();
	
	public String getName();
	
}
