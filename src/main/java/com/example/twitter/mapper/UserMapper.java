package com.example.twitter.mapper;

import com.example.twitter.api.user.LoginResponse;
import com.example.twitter.api.user.RegisterRequest;
import com.example.twitter.api.user.RegisterResponse;
import com.example.twitter.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper Instance = Mappers.getMapper(UserMapper.class);

    User map(RegisterRequest request);

    RegisterResponse map(User user);

    LoginResponse map2(User user);

}
