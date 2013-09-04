package com.supertool.dspui.exception;



public class DBException extends BasicException {

	private static final long serialVersionUID = -4038124216504868210L;

	public DBException() {
		super();
	}
	
	public DBException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DBException(String message) {
		super(message);
	}
	
	public DBException(Throwable cause) {
		super(cause);
	}
}
