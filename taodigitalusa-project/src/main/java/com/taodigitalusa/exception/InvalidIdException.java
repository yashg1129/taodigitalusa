package com.taodigitalusa.exception;

public class InvalidIdException extends Exception {

	private static final long serialVersionUID = -1917745595922856501L;
	
	private String message;

	public InvalidIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
