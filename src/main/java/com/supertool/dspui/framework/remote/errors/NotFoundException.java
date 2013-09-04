package com.supertool.dspui.framework.remote.errors;

public class NotFoundException extends Exception {

    private String message;
    /**
     * 
     */
    private static final long serialVersionUID = 1352419394028727817L;
    
    public NotFoundException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
