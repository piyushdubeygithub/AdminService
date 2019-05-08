package com.prosmv.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO <T>{

	private String message;
	private String responseMessage;
	private Date timestamp;
	private int status;
	private boolean error;
	private T responseObject;

	public ResponseDTO() {

	}

	public ResponseDTO(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public ResponseDTO(String responseMessage, String message) {
		this.responseMessage = responseMessage;
		this.message = message;
	}
	
	public ResponseDTO(int status, boolean success,String responseMessage,  T data) {
		super();
		this.status = status;
		this.error = success;
		this.responseMessage = responseMessage;
		this.responseObject = data;
	}
	

	public ResponseDTO(int status, boolean success,String responseMessage,  String message) {
		this.status = status;
		this.error = success;
		this.responseMessage = responseMessage;
		this.message = message;
	}
	
	public ResponseDTO(int status, boolean success,String responseMessage, String message, T data) {
		this.status = status;
		this.error = success;
		this.responseMessage = responseMessage;
		this.message = message;
		this.responseObject = data;
	}
	public ResponseDTO(String responseMessage, String message, T responseObject) {
		this.responseMessage = responseMessage;
		this.message = message;
		this.responseObject = responseObject;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(T responseObject) {
		this.responseObject = responseObject;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}


}
