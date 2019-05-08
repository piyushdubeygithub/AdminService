package com.prosmv.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.prosmv.constants.enums.FactoryMemberShip;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Factory implements Serializable {

	private static final long serialVersionUID = 6207680039364780262L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String mobileNumber;
	private String address;
	private String email;
	@Enumerated(EnumType.STRING)
	private FactoryMemberShip membership;
	private Timestamp licenseExpDate;
	@CreatedDate
	private Timestamp licenseIssueDate;
	private boolean isActive;
	private boolean deleted = false;
	@ManyToOne
	private Company company;
	@CreatedBy
	private User createdBy;
	@OneToOne
	private User updatedBy;
	@CreationTimestamp
	private Timestamp createdDate;
	@UpdateTimestamp
	private Timestamp updatedDate;
	@UpdateTimestamp
	private Timestamp deletedDate;

	@OneToOne
	private Document document;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FactoryMemberShip getMembership() {
		return membership;
	}

	public void setMembership(FactoryMemberShip membership) {
		this.membership = membership;
	}

	public Timestamp getLicenseExpDate() {
		return licenseExpDate;
	}

	public void setLicenseExpDate(Timestamp licenseExpDate) {
		this.licenseExpDate = licenseExpDate;
	}

	public Timestamp getLicenseIssueDate() {
		return licenseIssueDate;
	}

	public void setLicenseIssueDate(Timestamp licenseIssueDate) {
		this.licenseIssueDate = licenseIssueDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((licenseExpDate == null) ? 0 : licenseExpDate.hashCode());
		result = prime * result + ((licenseIssueDate == null) ? 0 : licenseIssueDate.hashCode());
		result = prime * result + ((membership == null) ? 0 : membership.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
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
		Factory other = (Factory) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (licenseExpDate == null) {
			if (other.licenseExpDate != null)
				return false;
		} else if (!licenseExpDate.equals(other.licenseExpDate))
			return false;
		if (licenseIssueDate == null) {
			if (other.licenseIssueDate != null)
				return false;
		} else if (!licenseIssueDate.equals(other.licenseIssueDate))
			return false;
		if (membership == null) {
			if (other.membership != null)
				return false;
		} else if (!membership.equals(other.membership))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Factory [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address=" + address
				+ ", email=" + email + ", membership=" + membership + ", licenseExpDate=" + licenseExpDate
				+ ", licenseIssueDate=" + licenseIssueDate + ", isActive=" + isActive + ", company=" + company
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Timestamp getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Timestamp deletedDate) {
		this.deletedDate = deletedDate;
	}

}
