package org.pk.edog.controller;

import org.pk.edog.model.entity.User;
import org.pk.edog.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public HttpEntity<String> login(@RequestBody User user) {
        String token = userService.login(user);

        if (nonNull(token)) {
            return new HttpEntity<>("Login successful, bearer token: " + token);
        } else {
            return new HttpEntity<>("Login failed");
        }
    }

//    @PostMapping("/register")
//    public HttpEntity<String> register( @RequestBody User user  ) {
//        try {
//            userService.register(user);
//            return new HttpEntity<>("User registered successfully");
//        } catch (IllegalArgumentException e) {
//            return new HttpEntity<>("User with username " + user.getUsername() + " already exists");
//        }
//    }

}
