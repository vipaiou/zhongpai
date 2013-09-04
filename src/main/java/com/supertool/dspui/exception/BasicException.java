package com.supertool.dspui.exception;



public class BasicException extends RuntimeException {

	private static final long serialVersionUID = 3950664506209908199L;

	public BasicException() {
		super();
	}
	
	public BasicException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BasicException(String message) {
		super(message);
	}
	
	public BasicException(Throwable cause) {
		super(cause);
	}
}
