package com.magnavalor.login.user.domain.service;

import com.magnavalor.login.user.domain.model.User;
import com.magnavalor.login.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    public Optional<User> byId(User user){
        return userRepository.findById(user.getId());
    }
    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public String deleteUser(Long Id){
        Optional<User> returnedUser = userRepository.findById(Id);
        returnedUser.ifPresentOrElse(user -> {
            userRepository.delete(user);
        },()->{
            System.out.println("User not found");
        });
        return "User is successfully deleted";
    }
    public Optional<User> updateUser(User user){
        byId(user).ifPresentOrElse(lambdaUser -> {
            lambdaUser.setUserName(user.getUserName());
            lambdaUser.setId(user.getId());
            lambdaUser.setPassword(user.getPassword());
            userRepository.save(lambdaUser);
        },()->{
            System.out.println("User not found");
        });
        return getUser(user);
    }

    public Optional<User> getUser(User user){
        byId(user).ifPresentOrElse(
            Optional::of
        ,()->{
            System.out.println("User not found");
        });
        return byId(user);
    }


}
