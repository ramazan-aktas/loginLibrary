package com.magnavalor.login.user.api;

import com.magnavalor.login.user.domain.model.User;
import com.magnavalor.login.user.domain.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(userService.validateUser(user)), HttpStatus.CREATED);
    }
    @PatchMapping
    public ResponseEntity<Optional<User>> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Optional<User>> getUser(@RequestBody User user){
        return new ResponseEntity<>(userService.getUser(user), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestBody User user){
        return new ResponseEntity<>(userService.deleteUser(user), HttpStatus.ACCEPTED);
    }
    @GetMapping("/{username}/{email}")
    public ResponseEntity<User> checkUser(@PathVariable("username") String userName, @PathVariable("email") String email){
        return new ResponseEntity<>(userService.getByEmailAndUserName(userName, email), HttpStatus.ACCEPTED);
    }

}
