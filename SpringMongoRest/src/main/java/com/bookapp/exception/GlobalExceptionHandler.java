package com.bookapp.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleMissingServletRequestParameter(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, 
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		LocalDateTime timestamp=LocalDateTime.now();
		List<String> details=Arrays.asList("mismatch","not supported");
		APIErrors errors=new APIErrors(message, timestamp, status, details);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		LocalDateTime timestamp=LocalDateTime.now();
		List<String> details=Arrays.asList("wrong method name","not supported");
		APIErrors errors=new APIErrors(message, timestamp, status, details);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		LocalDateTime timestamp=LocalDateTime.now();
		List<String> details=Arrays.asList("wrong media type","not supported");
		APIErrors errors=new APIErrors(message, timestamp, status, details);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		LocalDateTime timestamp=LocalDateTime.now();
		List<String> details=Arrays.asList("wrong path name","not supported");
		APIErrors errors=new APIErrors(message, timestamp, status, details);
		return ResponseEntity.status(status).body(errors);
			
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleMissingServletRequestPart(ex, headers, status, request);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	protected ResponseEntity<Object> handlerBookException(BookNotFoundException ex){
		String message=ex.getMessage();
		LocalDateTime timestamp=LocalDateTime.now();
		List<String> details=Arrays.asList("Book is not available");
		APIErrors errors=new APIErrors(message,timestamp,HttpStatus.BAD_REQUEST,details);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handlerotherException(Exception ex){
		String message=ex.getMessage();
		LocalDateTime timestamp=LocalDateTime.now();
		List<String> details=Arrays.asList(message);
		APIErrors errors=new APIErrors(message,timestamp,HttpStatus.INTERNAL_SERVER_ERROR,details);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);
		
	}
	
	public GlobalExceptionHandler() {
		
	}

}
