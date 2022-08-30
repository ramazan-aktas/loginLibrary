package com.magnavalor.login.user.exceptions;

public class EmailNotValid extends RuntimeException{
    public EmailNotValid() {
        super("Email is not valid");
    }
}
