package com.prosmv.exception;

/**
 * This is an custom exception that will be throw when an error has been occures
 * while performing operations related to company.
 * 
 * @author piyush
 *
 */
public class CompanyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CompanyException() {
		super();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public CompanyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public CompanyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public CompanyException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public CompanyException(Throwable arg0) {
		super(arg0);
	}

}
