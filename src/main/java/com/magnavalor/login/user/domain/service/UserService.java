package com.magnavalor.login.user.domain.service;

import com.magnavalor.login.user.domain.model.User;
import com.magnavalor.login.user.domain.repository.UserRepository;
import com.magnavalor.login.user.exceptions.EmailExists;
import com.magnavalor.login.user.exceptions.EmailNotValid;
import com.magnavalor.login.user.exceptions.UserNameTaken;
import com.magnavalor.login.user.exceptions.UserNotFound;
import org.springframework.stereotype.Service;
import java.util.Optional;

import static com.magnavalor.login.user.util.ValidateEmail.isValidEmail;

@Service
public class UserService {
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> byId(User user){
        return userRepository.findById(user.getId());
    }
    final
    UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public String deleteUser(User user){
        byId(user).ifPresentOrElse(lambdaUser -> {
            userRepository.delete(lambdaUser);
        },()->{
            throw new UserNotFound();
        });
        return "User is successfully deleted";
    }
    public Optional<User> updateUser(User user){
        byId(user).ifPresentOrElse(lambdaUser -> {
            lambdaUser.setUserName(user.getUserName());
            lambdaUser.setId(user.getId());
            lambdaUser.setPassword(user.getPassword());
            lambdaUser.setEmail(user.getEmail());
            userRepository.save(lambdaUser);
        },()->{
            throw new UserNotFound();
        });
        return getUser(user);
    }

    public Optional<User> getUser(User user){
        byId(user).ifPresentOrElse(
            Optional::of
        ,()->{
            throw new UserNotFound();
        });
        return byId(user);
    }

    public User getByEmailAndUserName(String userName, String email){
        return userRepository.findByEmailAndUserName(userName, email);
    }
    public User sanitizeUser(User user) {
        if (!isValidEmail(user)){
            throw new EmailNotValid();
        } else if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new UserNameTaken();
        } else if (userRepository.findByEmail(user.getEmail()) != null){
            throw new EmailExists();
        }else {
            return user;
        }
    }

}
