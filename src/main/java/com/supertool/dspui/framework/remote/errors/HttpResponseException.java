package com.supertool.dspui.framework.remote.errors;


public class HttpResponseException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = -522175096739536645L;
    
    private String message;
    
    private Integer statusCode;
    
    public HttpResponseException(Integer statusCode, String message){
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
    
}