package com.calipsoide.backend4testers.exceptions;

public class AlreadyRegisteredException extends RuntimeException {

    public AlreadyRegisteredException() {
        super("Username or email already registered. Please select different values.");
    }

}
