package com.cg.exceptions;

	@SuppressWarnings("serial")
	public class CustomerNotFoundException extends RuntimeException {

		public CustomerNotFoundException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CustomerNotFoundException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}

		public CustomerNotFoundException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}

		public CustomerNotFoundException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}
	}

