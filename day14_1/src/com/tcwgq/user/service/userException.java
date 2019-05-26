package com.tcwgq.user.service;

public class userException extends Exception {
	private static final long serialVersionUID = 1L;

	public userException() {
		super();
	}

	public userException(String message, Throwable cause) {
		super(message, cause);
	}

	public userException(String message) {
		super(message);
	}

	public userException(Throwable cause) {
		super(cause);
	}

}
