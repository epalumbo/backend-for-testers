package com.calipsoide.backend4testers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "USERS")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @NotNull
    String username;

    @NotNull
    @JsonIgnore
    String password;

    @NotNull
    String email;

    String superpower;

    @Column(name = "DATE_OF_BIRTH")
    LocalDate dateOfBirth;

    @Column(name = "IS_ADMIN")
    Boolean isAdmin;

}