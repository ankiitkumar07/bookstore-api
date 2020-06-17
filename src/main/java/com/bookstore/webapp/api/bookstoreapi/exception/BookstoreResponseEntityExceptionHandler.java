package com.bookstore.webapp.api.bookstoreapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class BookstoreResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest wr){
		
		ExceptionResponse er = new ExceptionResponse(new Date(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<Object>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest wr){
		
		ExceptionResponse er = new ExceptionResponse(new Date(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<Object>(er, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public final ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex, WebRequest wr){
		
		ExceptionResponse er = new ExceptionResponse(new Date(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<Object>(er, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AuthorNotFoundException.class)
	public final ResponseEntity<Object> handleAuthorNotFoundException(AuthorNotFoundException ex, WebRequest wr){
		ExceptionResponse er = new ExceptionResponse(new Date(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<Object>(er, HttpStatus.NOT_FOUND);
	}
}
