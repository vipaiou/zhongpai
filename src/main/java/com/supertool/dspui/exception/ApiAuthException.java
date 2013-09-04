package com.supertool.dspui.exception;

/**
 * API的验证参数错误
 * @author supertool
 *
 */
public class ApiAuthException extends BadRequestException {

    private static final long serialVersionUID = -854193070353175234L;

    public ApiAuthException() {
		super();
	}
	
	public ApiAuthException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ApiAuthException(String message) {
		super(message);
	}
	
	public ApiAuthException(Throwable cause) {
		super(cause);
	}
}
