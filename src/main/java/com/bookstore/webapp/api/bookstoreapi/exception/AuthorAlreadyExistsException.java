package com.bookstore.webapp.api.bookstoreapi.exception;

public class AuthorAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AuthorAlreadyExistsException(String msg) {
		super(msg);
	}

}
