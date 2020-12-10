package com.cg.exceptions;

@SuppressWarnings("serial")
public class BookingNotFoundException extends RuntimeException {
	
	public BookingNotFoundException(String message) {
	
		super(message);

}

	public BookingNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BookingNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}