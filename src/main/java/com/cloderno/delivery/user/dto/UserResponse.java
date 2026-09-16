package com.cloderno.delivery.user.dto;

import com.cloderno.delivery.user.entity.Role;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String phoneNumber,
        Role role
) {
}
