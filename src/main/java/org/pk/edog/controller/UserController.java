package org.pk.edog.controller;

import org.pk.edog.model.entity.User;
import org.pk.edog.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        String token = userService.login(user);
        Map<String, String> response = new HashMap<>();

        if (nonNull(token)) {
            response.put("message", "Login successful");
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Login failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

//    @PostMapping("/register")
//    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
//        Map<String, String> response = new HashMap<>();
//        try {
//            userService.register(user);
//            response.put("message", "User registered successfully");
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        } catch (IllegalArgumentException e) {
//            response.put("message", "User with username " + user.getUsername() + " already exists");
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
//        }
//    }

}
