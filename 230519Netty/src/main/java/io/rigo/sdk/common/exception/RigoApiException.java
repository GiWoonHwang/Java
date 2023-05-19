package io.rigo.sdk.common.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RigoApiException extends RuntimeException {

    public RigoApiException(String message) {
        super(message);
    }

}
