package com.prosmv.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.prosmv.constants.enums.DocumentType;

/**
 * This is an entity class used to store all the doucments either image , video
 * etc.
 * 
 * @author piyush
 *
 */
@Entity
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1894432675148881442L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private DocumentType documentType;

	@Column(nullable = false)
	private String s3BucketFileName;

	@CreationTimestamp
	@Column
	private Timestamp uploadedAt;

	@UpdateTimestamp
	@Column
	private Timestamp reUploadedAt;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the documentType
	 */
	public DocumentType getDocumentType() {
		return documentType;
	}

	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	/**
	 * @return the s3BucketFileName
	 */
	public String getS3BucketFileName() {
		return s3BucketFileName;
	}

	/**
	 * @param s3BucketFileName the s3BucketFileName to set
	 */
	public void setS3BucketFileName(String s3BucketFileName) {
		this.s3BucketFileName = s3BucketFileName;
	}

	/**
	 * @return the uploadedAt
	 */
	public Timestamp getUploadedAt() {
		return uploadedAt;
	}

	/**
	 * @param uploadedAt the uploadedAt to set
	 */
	public void setUploadedAt(Timestamp uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	/**
	 * @return the reUploadedAt
	 */
	public Timestamp getReUploadedAt() {
		return reUploadedAt;
	}

	/**
	 * @param reUploadedAt the reUploadedAt to set
	 */
	public void setReUploadedAt(Timestamp reUploadedAt) {
		this.reUploadedAt = reUploadedAt;
	}

	/**
	 * 
	 */
	public Document() {
		super();
	}

	/**
	 * @param id
	 * @param documentType
	 * @param s3BucketFileName
	 * @param uploadedAt
	 * @param reUploadedAt
	 */
	public Document(Long id, DocumentType documentType, String s3BucketFileName, Timestamp uploadedAt,
			Timestamp reUploadedAt) {
		super();
		this.id = id;
		this.documentType = documentType;
		this.s3BucketFileName = s3BucketFileName;
		this.uploadedAt = uploadedAt;
		this.reUploadedAt = reUploadedAt;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", documentType=" + documentType + ", s3BucketFileName=" + s3BucketFileName
				+ ", uploadedAt=" + uploadedAt + ", reUploadedAt=" + reUploadedAt + "]";
	}

}
