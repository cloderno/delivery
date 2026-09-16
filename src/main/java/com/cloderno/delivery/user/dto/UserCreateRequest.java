package com.cloderno.delivery.user.dto;

import com.cloderno.delivery.user.entity.Role;

public record UserCreateRequest(
        String phoneNumber,
        String password,
        Role role
) {
}
