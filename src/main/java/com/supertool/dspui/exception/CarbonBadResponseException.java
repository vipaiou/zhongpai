package com.supertool.dspui.exception;

/**
 * Carbon返回信息状态码非200
 * 
 * @author supertool
 * 
 */
public class CarbonBadResponseException extends RuntimeException {

	private static final long serialVersionUID = -5412498441445297031L;

	public CarbonBadResponseException() {
		super();
	}

	public CarbonBadResponseException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarbonBadResponseException(String message) {
		super(message);
	}

	public CarbonBadResponseException(Throwable cause) {
		super(cause);
	}
}
