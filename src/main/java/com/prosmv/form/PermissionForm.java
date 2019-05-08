package com.prosmv.form;

import java.util.List;

public class PermissionForm {

	private Long companyId;
	private String roleName;
	List<SubModulePermissionForm> subModulePermissionForms;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

//	public String getSubModuleName() {
//		return subModuleName;
//	}
//
//	public void setSubModuleName(String subModuleName) {
//		this.subModuleName = subModuleName;
//	}
//
//	public boolean isCanAccess() {
//		return canAccess;
//	}
//
//	public void setCanAccess(boolean canAccess) {
//		this.canAccess = canAccess;
//	}
//
//	public boolean isCanView() {
//		return canView;
//	}
//
//	public void setCanView(boolean canView) {
//		this.canView = canView;
//	}
//
//	public boolean isCanSave() {
//		return canSave;
//	}
//
//	public void setCanSave(boolean canSave) {
//		this.canSave = canSave;
//	}
//
//	public boolean isCanUpdate() {
//		return canUpdate;
//	}
//
//	public void setCanUpdate(boolean canUpdate) {
//		this.canUpdate = canUpdate;
//	}
//
//	public boolean isCanDelete() {
//		return canDelete;
//	}
//
//	public void setCanDelete(boolean canDelete) {
//		this.canDelete = canDelete;
//	}
//
//	public boolean isCanSendForApproval() {
//		return canSendForApproval;
//	}
//
//	public void setCanSendForApproval(boolean canSendForApproval) {
//		this.canSendForApproval = canSendForApproval;
//	}
//
//	public boolean isCanApprove() {
//		return canApprove;
//	}
//
//	public void setCanApprove(boolean canApprove) {
//		this.canApprove = canApprove;
//	}
//
//	public boolean isCanPrint() {
//		return canPrint;
//	}
//
//	public void setCanPrint(boolean canPrint) {
//		this.canPrint = canPrint;
//	}


	public List<SubModulePermissionForm> getSubModulePermissionForms() {
		return subModulePermissionForms;
	}

	public void setSubModulePermissionForms(List<SubModulePermissionForm> subModulePermissionForms) {
		this.subModulePermissionForms = subModulePermissionForms;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}
