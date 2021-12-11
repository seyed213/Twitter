package com.example.twitter.service;

import com.example.twitter.api.post.CreatePostRequest;
import com.example.twitter.api.post.CreatePostResponse;

public interface PostService {

    CreatePostResponse create(CreatePostRequest request) throws Exception;


}
