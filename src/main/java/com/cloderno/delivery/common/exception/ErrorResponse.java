package com.cloderno.delivery.common.exception;

import java.util.Map;

public record ErrorResponse(
        ErrorCode errorCode,
        String message,
        Map<String, Object> details
) {
    public ErrorResponse(
            ErrorCode errorCode,
            String message
    ) {
        this(errorCode, message, Map.of());
    }
}
