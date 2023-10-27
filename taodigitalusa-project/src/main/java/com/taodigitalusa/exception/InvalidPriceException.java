package com.taodigitalusa.exception;

public class InvalidPriceException extends Exception {

	private static final long serialVersionUID = -1917745595922856501L;
	
	private String message;

	public InvalidPriceException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
