package com.bookstore.webapp.api.bookstoreapi.exception;

public class GenreNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GenreNotFoundException(String msg) {
		super(msg);
	}

	
}
