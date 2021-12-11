package com.example.twitter.controller;

import com.example.twitter.api.user.LoginRequest;
import com.example.twitter.api.user.RegisterRequest;
import com.example.twitter.api.user.RegisterResponse;
import com.example.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user/register")
    public ResponseEntity<?> userRegister(@Valid @RequestBody RegisterRequest request) {

        try {
            RegisterResponse response = userService.register(request);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not valid");
        }
    }

    @PostMapping("user/login")
    public ResponseEntity<?> userLogin(@Valid @RequestBody LoginRequest request) {
        try {
            return ResponseEntity.ok().body(userService.login(request));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body("your Account Not Found");
        }

    }

}
