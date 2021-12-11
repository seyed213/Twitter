package com.example.twitter.service;

import com.example.twitter.api.post.PostModel;

import java.util.List;

public interface HashtagService {

   List<PostModel> findPostByHashtag(String request) throws Exception;

}
