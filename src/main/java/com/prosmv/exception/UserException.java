package com.prosmv.exception;

import com.prosmv.domain.User;

/**
 * This is an custom exception that will be throw when an error has been occures
 * while performing operations related to {@link User}.
 * 
 * @author piyush
 *
 */
public class UserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4911379252893261396L;

	/**
	 * 
	 */
	public UserException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UserException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UserException(Throwable cause) {
		super(cause);
	}

}
