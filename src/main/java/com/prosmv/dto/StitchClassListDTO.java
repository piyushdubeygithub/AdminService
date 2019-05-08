package com.prosmv.dto;

import java.util.List;

import com.prosmv.domain.StitchClass;

public class StitchClassListDTO {
	
	private List<StitchClass> stitchClassList;
	
	public StitchClassListDTO(List<StitchClass> stitchClassList) {
		this.stitchClassList = stitchClassList;
	}

	public List<StitchClass> getStitchClassList() {
		return stitchClassList;
	}

	public void setStitchClassList(List<StitchClass> stitchClassList) {
		this.stitchClassList = stitchClassList;
	}
	

}
