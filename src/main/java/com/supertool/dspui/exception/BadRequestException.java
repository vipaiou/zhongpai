package com.supertool.dspui.exception;

/**
 * 由于传入参数中存在错误而导致的异常
 *
 */
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -5291509084533139530L;
    public BadRequestException() {
		super();
	}
	
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BadRequestException(String message) {
		super(message);
	}
	
	public BadRequestException(Throwable cause) {
		super(cause);
	}
}

