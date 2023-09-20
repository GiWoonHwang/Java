package io.dustin.common.exception;

public class BadAuthorizeTokenException extends RuntimeException {

    public BadAuthorizeTokenException(String message) {
        super(message);
    }

}
