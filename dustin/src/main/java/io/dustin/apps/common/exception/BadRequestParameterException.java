package io.dustin.apps.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "bad request parameters")
public class BadRequestParameterException extends RuntimeException {
    public BadRequestParameterException(String message) {
        super(message);
    }
}
