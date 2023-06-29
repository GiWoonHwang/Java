package io.dustin.board.common.advice;

import io.dustin.board.common.exception.BadRequestParameterException;
import io.dustin.board.common.exception.DataNotFoundException;
import io.dustin.board.common.utils.SelectDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.time.LocalDateTime.now;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataNotFoundException.class)
    protected ApiError handleDataNotFoundException(DataNotFoundException e) {
        return ApiError.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .timestamp(SelectDate.TYPE_FOUR.transform(now()))
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestParameterException.class)
    protected ApiError handleBadRequestParameterException(BadRequestParameterException e) {
        return ApiError.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .timestamp(SelectDate.TYPE_FOUR.transform(now()))
                .build();
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class ApiError {
        private int status;
        private String message;
        private String timestamp;
    }

}
