package com.calipsoide.backend4testers.dto;

import com.calipsoide.backend4testers.model.User;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@ToString
public final class UserDTO {

    Long id;

    String name;

    String username;

    String password;

    String email;

    String superpower;

    LocalDate dateOfBirth;

    Boolean isAdmin;

    public User toUser() {
        return User.builder()
                .id(id)
                .name(name)
                .username(username)
                .password(password)
                .email(email)
                .superpower(superpower)
                .dateOfBirth(dateOfBirth)
                .isAdmin(isAdmin)
                .build();
    }

}