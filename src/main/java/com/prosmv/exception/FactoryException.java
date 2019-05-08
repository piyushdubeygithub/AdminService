package com.prosmv.exception;

/**
 * This is an custom exception that will be throw when an error has been occures
 * while performing operations related to factory.
 * 
 * @author piyush
 *
 */
public class FactoryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public FactoryException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public FactoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FactoryException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public FactoryException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public FactoryException(Throwable cause) {
		super(cause);
	}

}
