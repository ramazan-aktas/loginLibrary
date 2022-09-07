package com.magnavalor.login.user.exceptions;

public class UserNameTaken extends RuntimeException{
    public UserNameTaken() {
        super("Email is not valid");
    }
}
