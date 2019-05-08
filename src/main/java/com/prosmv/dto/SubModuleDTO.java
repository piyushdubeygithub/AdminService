package com.prosmv.dto;

import java.io.Serializable;
import com.prosmv.domain.Module;
import com.prosmv.domain.SubModule;

public class SubModuleDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4272020675162943729L;

	private Long id;
	private String subModuleName;
	private String linkId;
	private String direct;
	Module module;
	
	public SubModuleDTO(SubModule subModule) {
		if(subModule != null) {
			this.id = subModule.getId();
			this.subModuleName = subModule.getSubModuleName();
		}
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubModuleName() {
		return subModuleName;
	}
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	public String getLinkId() {
		return linkId;
	}
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}
	public String getDirect() {
		return direct;
	}
	public void setDirect(String direct) {
		this.direct = direct;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
