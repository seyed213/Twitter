package com.example.twitter.repository;

import com.example.twitter.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

    @Query(value = "SELECT EXISTS (SELECT * FROM hashtag WHERE hashtag.text=text)", nativeQuery = true)
    boolean chekExist(String text);

    Hashtag findByText(String text);

}
