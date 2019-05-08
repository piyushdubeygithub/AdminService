package com.prosmv.form;

public class SubModulePermissionForm {

	private Long subModuleId;
	private String subModuleName;
	private boolean canAccess;
	private boolean canView;
	private boolean canSave;
	private boolean canUpdate;
	private boolean canDelete;
	private boolean canSendForApproval;
	private boolean canApprove;
	private boolean canPrint;
	public Long getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(Long subModuleId) {
		this.subModuleId = subModuleId;
	}
	public String getSubModuleName() {
		return subModuleName;
	}
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	public boolean isCanAccess() {
		return canAccess;
	}
	public void setCanAccess(boolean canAccess) {
		this.canAccess = canAccess;
	}
	public boolean isCanView() {
		return canView;
	}
	public void setCanView(boolean canView) {
		this.canView = canView;
	}
	public boolean isCanSave() {
		return canSave;
	}
	public void setCanSave(boolean canSave) {
		this.canSave = canSave;
	}
	public boolean isCanUpdate() {
		return canUpdate;
	}
	public void setCanUpdate(boolean canUpdate) {
		this.canUpdate = canUpdate;
	}
	public boolean isCanDelete() {
		return canDelete;
	}
	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}
	public boolean isCanSendForApproval() {
		return canSendForApproval;
	}
	public void setCanSendForApproval(boolean canSendForApproval) {
		this.canSendForApproval = canSendForApproval;
	}
	public boolean isCanApprove() {
		return canApprove;
	}
	public void setCanApprove(boolean canApprove) {
		this.canApprove = canApprove;
	}
	public boolean isCanPrint() {
		return canPrint;
	}
	public void setCanPrint(boolean canPrint) {
		this.canPrint = canPrint;
	}
	
}
