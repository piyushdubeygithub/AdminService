package com.prosmv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.prosmv.constants.enums.TokenType;

@Entity
public class AuthenticationToken {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String token;

	@OneToOne
	private User user;

	@Column
	@Enumerated(EnumType.STRING)
	private TokenType tokenType;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the tokenType
	 */
	public TokenType getTokenType() {
		return tokenType;
	}

	/**
	 * @param tokenType the tokenType to set
	 */
	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}
}
