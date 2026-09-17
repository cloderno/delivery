package com.cloderno.delivery.exception;

import com.cloderno.delivery.common.exception.ErrorCode;
import com.cloderno.delivery.common.exception.ErrorResponse;
import com.cloderno.delivery.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {
    @InjectMocks
    private GlobalExceptionHandler handler;

    @Mock
    private MessageSource messageSource;

    @Test
    void shouldShowUserNotFound() {
        UUID id = UUID.randomUUID();
        Locale locale = Locale.ENGLISH;

        UserNotFoundException exception = new UserNotFoundException(id);

        when(messageSource.getMessage(
                "error.user.not.found",
                null,
                locale
        )).thenReturn("User not found");

        ErrorResponse result = handler.handleUserNotFoundException(exception, locale);

        assertEquals(ErrorCode.USER_NOT_FOUND, result.errorCode());
        assertEquals("User not found", result.message());
        assertEquals(id, result.details().get("userId"));
    }
}
