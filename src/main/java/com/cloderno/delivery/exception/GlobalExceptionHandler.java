package com.cloderno.delivery.exception;

import com.cloderno.delivery.common.exception.ErrorCode;
import com.cloderno.delivery.common.exception.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    // TODO: Add base exception
    // TODO: make a research about exceptions

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException(
            UserNotFoundException e,
            Locale locale
    ) {
        String message = messageSource.getMessage(
                "error.user.not.found",
                null,
                locale
        );

        return new ErrorResponse(
            ErrorCode.USER_NOT_FOUND,
            message,
            Map.of(
                "userId", e.getId()
            )
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException e,
            Locale locale
    ) {
        String message = messageSource.getMessage(
                "error.invalid.parameter",
                new Object[]{ Objects.requireNonNull(e.getValue()) }, // displaying value in messages arguments
                locale
        );

        return new ErrorResponse(
                ErrorCode.INVALID_PARAMETER,
                message
        );
    }
}
