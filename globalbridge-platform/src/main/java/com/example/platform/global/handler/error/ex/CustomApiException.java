package com.example.platform.global.handler.error.ex;

public class CustomApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public CustomApiException (String message) {
		super(message);
	}

}
