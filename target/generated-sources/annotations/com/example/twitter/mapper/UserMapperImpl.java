package com.example.twitter.mapper;

import com.example.twitter.api.user.LoginResponse;
import com.example.twitter.api.user.LoginResponse.LoginResponseBuilder;
import com.example.twitter.api.user.RegisterRequest;
import com.example.twitter.api.user.RegisterResponse;
import com.example.twitter.api.user.RegisterResponse.RegisterResponseBuilder;
import com.example.twitter.entity.User;
import com.example.twitter.entity.User.UserBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-18T15:22:16-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User map(RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        UserBuilder<?, ?> user = User.builder();

        user.userName( request.getUserName() );
        user.password( request.getPassword() );
        user.email( request.getEmail() );
        user.phoneNumber( request.getPhoneNumber() );

        return user.build();
    }

    @Override
    public RegisterResponse map(User user) {
        if ( user == null ) {
            return null;
        }

        RegisterResponseBuilder registerResponse = RegisterResponse.builder();

        registerResponse.id( user.getId() );
        registerResponse.userName( user.getUserName() );

        return registerResponse.build();
    }

    @Override
    public LoginResponse map2(User user) {
        if ( user == null ) {
            return null;
        }

        LoginResponseBuilder loginResponse = LoginResponse.builder();

        loginResponse.id( user.getId() );
        loginResponse.userName( user.getUserName() );
        loginResponse.email( user.getEmail() );
        loginResponse.phoneNumber( user.getPhoneNumber() );

        return loginResponse.build();
    }
}
