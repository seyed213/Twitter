package com.example.twitter.mapper;

import com.example.twitter.api.post.CreatePostRequest;
import com.example.twitter.api.post.CreatePostResponse;
import com.example.twitter.api.post.PostModel;
import com.example.twitter.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper Instance = Mappers.getMapper(PostMapper.class);

    Post map(CreatePostRequest request);

    CreatePostResponse map(Post post);

    PostModel map2(Post post);

}
