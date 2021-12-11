package com.example.twitter.service;

import com.example.twitter.api.user.LoginRequest;
import com.example.twitter.api.user.LoginResponse;
import com.example.twitter.api.user.RegisterRequest;
import com.example.twitter.api.user.RegisterResponse;
import com.example.twitter.entity.User;
import com.example.twitter.mapper.UserMapper;
import com.example.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterResponse register(RegisterRequest request) throws Exception {

        User user = UserMapper.Instance.map(request);
        User registeredUser = userRepository.save(user);
        RegisterResponse response = UserMapper.Instance.map(registeredUser);


        return response;
    }

    @Override
    public LoginResponse login(LoginRequest request) throws Exception {

        User user = userRepository.login(request.getUserName(), request.getPassword());

        if (user == null) {
            throw new Exception(" Login failed !!");
        } else {
            return UserMapper.Instance.map2(user);
        }


    }

}
