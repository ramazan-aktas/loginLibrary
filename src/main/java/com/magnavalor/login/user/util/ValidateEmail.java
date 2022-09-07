package com.magnavalor.login.user.util;

import com.magnavalor.login.user.domain.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ValidateEmail {
    public static Boolean isValidEmail(User user) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getEmail());
        return matcher.matches();
    }
}
