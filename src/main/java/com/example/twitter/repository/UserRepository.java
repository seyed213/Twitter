package com.example.twitter.repository;

import com.example.twitter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from `user` where user_name=:userName  and password=:password", nativeQuery = true)
    User login(String userName, String password);

    @Query(value = "SELECT EXISTS (SELECT * FROM user WHERE user.id=:id)", nativeQuery = true)
    BigInteger chekExist(Long id);
}
