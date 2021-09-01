package com.calipsoide.backend4testers.exceptions;

public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String username) {
        super("Username " + username + " does not exist.");
    }

}
