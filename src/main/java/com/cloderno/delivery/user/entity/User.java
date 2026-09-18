package com.cloderno.delivery.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
/**
 * Hibernate → может создать User ✅
 * твой Service → new User() ❌
 * твой Service → new User(phone, password, role) ✅
 * поэтому мы используем AccessLevel.Protected
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable = false, nullable = false)
    private UUID id;

    @Column(name="phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name="hashed_password", nullable = false)
    private String hashedPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
