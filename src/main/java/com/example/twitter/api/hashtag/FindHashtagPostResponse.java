package com.example.twitter.api.hashtag;

import com.example.twitter.api.post.PostModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindHashtagPostResponse {

    private List<PostModel> post;

}
