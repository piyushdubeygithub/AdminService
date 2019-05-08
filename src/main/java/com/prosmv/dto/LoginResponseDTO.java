package com.prosmv.dto;

import java.io.Serializable;

import com.prosmv.domain.User;

public class LoginResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7951940370038914177L;

	private String token;
	private UserDTO user;
	private String message;
	
	public LoginResponseDTO() {
	}
	public LoginResponseDTO(String message) {
		this.message = message;
	}
	public LoginResponseDTO(String token, User user, String message) {
		this.token = token;
		if(user != null) {
			this.user = new UserDTO(user, user.getUsername());
		}
		this.message = message;
	}
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
}
