package com.synechron.assignment.exceptions;

public class PlanNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlanNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlanNotFoundException(String message) {
		super(message);
	}

	public PlanNotFoundException(Throwable cause) {
		super(cause);
	
	}

}
