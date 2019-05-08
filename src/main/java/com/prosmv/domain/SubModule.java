package com.prosmv.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubModule implements Serializable{
	
	
	private static final long serialVersionUID = 7776518138654653344L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String subModuleName;
	private String linkId;
	private String direct;
	@ManyToOne
	Module module;
	
	public String getLinkId() {
		return linkId;
	}
	public String getDirect() {
		return direct;
	}
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}
	public void setDirect(String direct) {
		this.direct = direct;
	}
	public Long getSubModuleId() {
		return id;
	}
	public String getSubModuleName() {
		return subModuleName;
	}
	public void setSubModuleId(Long subModuleId) {
		this.id = subModuleId;
	}
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((direct == null) ? 0 : direct.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((linkId == null) ? 0 : linkId.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((subModuleName == null) ? 0 : subModuleName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubModule other = (SubModule) obj;
		if (direct == null) {
			if (other.direct != null)
				return false;
		} else if (!direct.equals(other.direct))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (linkId == null) {
			if (other.linkId != null)
				return false;
		} else if (!linkId.equals(other.linkId))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (subModuleName == null) {
			if (other.subModuleName != null)
				return false;
		} else if (!subModuleName.equals(other.subModuleName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SubModule [id=" + id + ", subModuleName=" + subModuleName + ", linkId=" + linkId + ", direct=" + direct
				+ ", module=" + module + "]";
	}

}
