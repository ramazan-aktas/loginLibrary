package com.magnavalor.login.user.exceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound() {
        super("User not found");
    }
}

