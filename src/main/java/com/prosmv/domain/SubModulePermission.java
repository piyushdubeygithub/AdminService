package com.prosmv.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class SubModulePermission implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2321758668018539178L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean canAccess;
	private boolean canView;
	private boolean canSave;
	private boolean canUpdate;
	private boolean canDelete;
	private boolean canSendForApproval;
	private boolean canApprove;
	private boolean canPrint;
	@ManyToOne
	private Role role;
	@OneToOne
	private SubModule subModule;
	@OneToOne
	private User createdBy;
	@OneToOne
	private User updatedBy;
	
	@CreationTimestamp
	private Timestamp createdAt;
	
	@UpdateTimestamp
	private Timestamp updatedAt;

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public SubModule getSubModule() {
		return subModule;
	}

	public void setSubModule(SubModule subModule) {
		this.subModule = subModule;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (canAccess ? 1231 : 1237);
		result = prime * result + (canApprove ? 1231 : 1237);
		result = prime * result + (canDelete ? 1231 : 1237);
		result = prime * result + (canPrint ? 1231 : 1237);
		result = prime * result + (canSave ? 1231 : 1237);
		result = prime * result + (canSendForApproval ? 1231 : 1237);
		result = prime * result + (canUpdate ? 1231 : 1237);
		result = prime * result + (canView ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((subModule == null) ? 0 : subModule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubModulePermission other = (SubModulePermission) obj;
		if (canAccess != other.canAccess)
			return false;
		if (canApprove != other.canApprove)
			return false;
		if (canDelete != other.canDelete)
			return false;
		if (canPrint != other.canPrint)
			return false;
		if (canSave != other.canSave)
			return false;
		if (canSendForApproval != other.canSendForApproval)
			return false;
		if (canUpdate != other.canUpdate)
			return false;
		if (canView != other.canView)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (subModule == null) {
			if (other.subModule != null)
				return false;
		} else if (!subModule.equals(other.subModule))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubModulePermission [id=" + id + ", role=" + role + ", subModule=" + subModule + ", canAccess="
				+ canAccess + ", canView=" + canView + ", canSave=" + canSave + ", canUpdate=" + canUpdate
				+ ", canDelete=" + canDelete + ", canSendForApproval=" + canSendForApproval + ", canApprove="
				+ canApprove + ", canPrint=" + canPrint + "]";
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
	
}
