//package com.prosmv.domain;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//@Entity
//public class LicensedModule implements Serializable{
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	private String moduleName;
//	private String validUpto;
//	@ManyToOne
//	private SubModule subModules;
//	
//	
//	public SubModule getSubModules() {
//		return subModules;
//	}
//	public void setSubModules(SubModule subModules) {
//		this.subModules = subModules;
//	}
//	public Long getModuleId() {
//		return id;
//	}
//	public String getModuleName() {
//		return moduleName;
//	}
//	public String getValidUpto() {
//		return validUpto;
//	}
//	public void setModuleId(Long moduleId) {
//		this.id = moduleId;
//	}
//	public void setModuleName(String moduleName) {
//		this.moduleName = moduleName;
//	}
//	public void setValidUpto(String validUpto) {
//		this.validUpto = validUpto;
//	}
//	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((moduleName == null) ? 0 : moduleName.hashCode());
//		result = prime * result + ((subModules == null) ? 0 : subModules.hashCode());
//		result = prime * result + ((validUpto == null) ? 0 : validUpto.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		LicensedModule other = (LicensedModule) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (moduleName == null) {
//			if (other.moduleName != null)
//				return false;
//		} else if (!moduleName.equals(other.moduleName))
//			return false;
//		if (subModules == null) {
//			if (other.subModules != null)
//				return false;
//		} else if (!subModules.equals(other.subModules))
//			return false;
//		if (validUpto == null) {
//			if (other.validUpto != null)
//				return false;
//		} else if (!validUpto.equals(other.validUpto))
//			return false;
//		return true;
//	}
//	
//	@Override
//	public String toString() {
//		return "LicensedModules [id=" + id + ", moduleName=" + moduleName + ", validUpto=" + validUpto + ", subModules="
//				+ subModules + "]";
//	}
//
//}
