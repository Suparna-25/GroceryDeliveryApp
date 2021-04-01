package com.cg.grocerydeliveryapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryIDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoryIDException() {
		super();
	}

	public CategoryIDException(String errMsg) {
		super(errMsg);
	}
}
