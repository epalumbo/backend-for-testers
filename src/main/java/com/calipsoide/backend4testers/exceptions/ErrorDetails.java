package com.calipsoide.backend4testers.exceptions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class ErrorDetails {

    @NotNull
    private Date timestamp;
    @NotNull
    private int status;
    @NotNull
    private String error;
    @NotNull
    private String message;
    @NotNull
    private String path;
}
