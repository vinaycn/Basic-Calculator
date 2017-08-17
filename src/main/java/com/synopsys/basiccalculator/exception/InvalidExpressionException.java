package com.synopsys.basiccalculator.exception;

public class InvalidExpressionException extends Exception {

    private static final long serialVersionUID = 6126690489984356487L;
	
	private static String description = "Invalid Expression is provided: ";
	
	public InvalidExpressionException(String message) {
		super(description + message);
	}
}
