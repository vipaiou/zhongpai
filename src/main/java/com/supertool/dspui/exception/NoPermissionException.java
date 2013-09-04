package com.supertool.dspui.exception;

import org.springframework.security.authentication.AccountStatusException;

public class NoPermissionException extends AccountStatusException {
    // ~ Constructors
    // ===================================================================================================

    private static final long serialVersionUID = 5001193875012623263L;

    /**
     * Constructs a <code>DisabledException</code> with the specified message.
     * 
     * @param msg
     *            the detail message
     */
    public NoPermissionException(String msg) {
        super(msg);
    }

    /**
     * Constructs a <code>DisabledException</code> with the specified message
     * and root cause.
     * 
     * @param msg
     *            the detail message
     * @param t
     *            root cause
     */
    public NoPermissionException(String msg, Throwable t) {
        super(msg, t);
    }

    @SuppressWarnings("deprecation")
    public NoPermissionException(String msg, Object extraInformation) {
        super(msg, extraInformation);
    }
}
