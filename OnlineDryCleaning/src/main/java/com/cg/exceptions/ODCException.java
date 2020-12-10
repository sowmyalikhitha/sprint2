package com.cg.exceptions;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ODCException extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ OrderNotFoundException.class })
	public ResponseEntity<ExceptionDetails> handleException(OrderNotFoundException exception, WebRequest request) {
		ExceptionDetails details = new ExceptionDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
		ExceptionDetails details = new ExceptionDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<Object>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler({ CustomerNotFoundException.class })
	public ResponseEntity<ExceptionDetails> handleException(CustomerNotFoundException exception, WebRequest request) {
		ExceptionDetails details = new ExceptionDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

}