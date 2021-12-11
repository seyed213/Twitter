package com.example.twitter.api.post;

import com.example.twitter.api.hashtag.HashtagModel;
import com.example.twitter.api.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePostResponse {

    private Long id;
    private String text;
    private UserModel userModel;
    private ArrayList<HashtagModel> hashtag;
}
