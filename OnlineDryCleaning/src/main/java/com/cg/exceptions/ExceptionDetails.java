package com.cg.exceptions;

import java.time.LocalDate;

public class ExceptionDetails {
	private String message;
	private LocalDate dateTime;
	private String details;

	public ExceptionDetails(String message, LocalDate dateTime, String details) {
		super();
		this.message = message;
		this.dateTime = dateTime;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}