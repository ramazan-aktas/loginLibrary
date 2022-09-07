package com.magnavalor.login.user.exceptions;


public class EmailExists extends RuntimeException{
    public EmailExists() {
        super("Email is not valid");
    }
}