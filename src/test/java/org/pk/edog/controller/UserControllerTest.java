package org.pk.edog.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.pk.edog.model.entity.User;
import org.pk.edog.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void Login_ReturnsToken() {
        when(userService.login(any())).thenReturn("TestToken");

        User user = new User() { username = "TestUsername", password = "TestPassword" }
        ResponseEntity<String> response = userController.Login(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Login successful", response.getBody().message);
    }

    @Test
    void Login_ReturnsUnauthorized() {
        when(userService.login(any())).thenReturn(null);

        User user = new User() { username = "TestUsername", password = "TestPassword" }
        ResponseEntity<String> response = userController.Login(user);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Login failed", response.getBody().message);
    }
}