package com.prosmv.dto.response;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * This class is used to store the api responses for all the microservice
 * endpoint.
 * 
 * @author piyush
 *
 */
public class ResponseDTO {
	private Object data;
	private String message;
	private boolean isSuccess;
	private int httpStatus;
	@JsonInclude(value = Include.NON_NULL)
	private String errorCode;
	private long timestamp;

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the isSuccess
	 */
	public boolean isSuccess() {
		return isSuccess;
	}

	/**
	 * @param isSuccess the isSuccess to set
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * @return the httpStatus
	 */
	public int getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseDTO [data=" + data + ", message=" + message + ", isSuccess=" + isSuccess + ", httpStatus="
				+ httpStatus + ", errorCode=" + errorCode + ", timestamp=" + timestamp + "]";
	}

	/**
	 * @param data
	 * @param message
	 * @param isSuccess
	 * @param httpStatus
	 * @param errorCode
	 */
	public ResponseDTO(Object data, String message, boolean isSuccess, int httpStatus, String errorCode) {
		super();
		this.data = data;
		this.message = message;
		this.isSuccess = isSuccess;
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
	}

	/**
	 * 
	 */
	public ResponseDTO() {
		super();
	}

}
