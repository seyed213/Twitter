package com.example.twitter.mapper;

import com.example.twitter.api.hashtag.FindHashtagPostRequest;
import com.example.twitter.entity.Hashtag;
import com.example.twitter.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HashtagMapper {

    HashtagMapper instance = Mappers.getMapper(HashtagMapper.class);

    Hashtag map(FindHashtagPostRequest request);

}
