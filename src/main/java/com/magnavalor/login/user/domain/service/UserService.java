package com.magnavalor.login.user.domain.service;

import com.magnavalor.login.user.domain.model.User;
import com.magnavalor.login.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
}
