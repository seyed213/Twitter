package com.example.twitter.controller;

import com.example.twitter.api.post.CreatePostRequest;
import com.example.twitter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("post/create")
    public ResponseEntity<?> createPost(@Valid @RequestBody CreatePostRequest request) {
        try {
            return ResponseEntity.ok().body(postService.create(request));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Not valid");
        }
    }
}
