package com.prosmv.exception;

/**
 * This is an custom exception that will be throw when an error has been occures
 * while performing operations related to image uploading.
 * 
 * @author piyush
 *
 */
public class ImageUploadException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1432082228727029432L;

	/**
	 * 
	 */
	public ImageUploadException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ImageUploadException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ImageUploadException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ImageUploadException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ImageUploadException(Throwable cause) {
		super(cause);
	}

}
