package com.shahab.crudsample.exception;

public class AvailableUserException extends RuntimeException{
    public AvailableUserException(String email) {
        super("Your email is available to another user: " + email);
    }
}
