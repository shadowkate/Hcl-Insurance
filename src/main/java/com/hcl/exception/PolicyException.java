package com.hcl.exception;

public class PolicyException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PolicyException(String message) {
		
		super(message);
	}
}
