package com.shahab.crudsample.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User id not found: " + id);
    }

    public UserNotFoundException(String email) {
        super("User email not found: " + email);
    }
}
