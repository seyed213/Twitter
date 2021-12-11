package com.example.twitter.controller;

import com.example.twitter.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HashtagController {

    @Autowired
    private HashtagService hashtagService;

    @GetMapping("hashtag/{text}")
    public ResponseEntity<?> findPostByHashtag(@PathVariable String text) {
        try {
            return ResponseEntity.ok(hashtagService.findPostByHashtag(text));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error ");
        }

    }


}
