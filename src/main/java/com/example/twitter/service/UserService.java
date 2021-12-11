package com.example.twitter.service;

import com.example.twitter.api.user.LoginRequest;
import com.example.twitter.api.user.LoginResponse;
import com.example.twitter.api.user.RegisterRequest;
import com.example.twitter.api.user.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest request) throws Exception;

    LoginResponse login(LoginRequest request) throws Exception;
}
