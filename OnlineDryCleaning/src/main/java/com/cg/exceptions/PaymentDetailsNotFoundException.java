package com.cg.exceptions;

public class PaymentDetailsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentDetailsNotFoundException() {
		super();
	}
	
	public PaymentDetailsNotFoundException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public PaymentDetailsNotFoundException(String message) {
		super(message);
	}
	
	public PaymentDetailsNotFoundException(Throwable cause) {
		super(cause);
	}
}