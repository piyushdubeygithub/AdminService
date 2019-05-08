package com.prosmv.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import com.prosmv.domain.SubModulePermission;

public class SubModulePermissionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8586679953037741760L;

	private Long id;
	private boolean canAccess;
	private boolean canView;
	private boolean canSave;
	private boolean canUpdate;
	private boolean canDelete;
	private boolean canSendForApproval;
	private boolean canApprove;
	private boolean canPrint;
	private String  roleName;
	private SubModuleDTO subModuleDTO;
	private UserDTO createdBy;
	private UserDTO updatedBy;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public SubModulePermissionDTO() {

	}

	public SubModulePermissionDTO(SubModulePermission subModulePermission) {
		if (subModulePermission != null) {
           this.canAccess = subModulePermission.isCanAccess();
           this.canApprove = subModulePermission.isCanApprove();
           this.canDelete = subModulePermission.isCanDelete();
           this.canPrint = subModulePermission.isCanDelete();
           this.canSave = subModulePermission.isCanSave();
           this.canSendForApproval = subModulePermission.isCanSendForApproval();
           this.canUpdate = subModulePermission.isCanUpdate();
           this.canView = subModulePermission.isCanView();
           this.createdAt = subModulePermission.getCreatedAt();
           this.updatedAt = subModulePermission.getUpdatedAt();
           if(subModulePermission.getRole() !=null && subModulePermission.getRole().getRoleName() !=null) {
        	   this.roleName = subModulePermission.getRole().getRoleName();
           }
           if(subModulePermission.getSubModule() != null) {
        	   this.subModuleDTO = new SubModuleDTO(subModulePermission.getSubModule());
           }
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SubModuleDTO getSubModuleDTO() {
		return subModuleDTO;
	}

	public void setSubModuleDTO(SubModuleDTO subModuleDTO) {
		this.subModuleDTO = subModuleDTO;
	}

	public UserDTO getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDTO createdBy) {
		this.createdBy = createdBy;
	}

	public UserDTO getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(UserDTO updatedBy) {
		this.updatedBy = updatedBy;
	}

}
