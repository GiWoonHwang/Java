package io.dustin.common.exception;

public class BadRequestParameterException extends RuntimeException {
    public BadRequestParameterException(String message) {
        super(message);
    }
}
