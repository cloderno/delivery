package com.cloderno.delivery.exception;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final UUID id;

    public UserNotFoundException(UUID id) {
        this.id = id;
    }
}
