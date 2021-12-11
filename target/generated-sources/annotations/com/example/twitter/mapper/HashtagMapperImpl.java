package com.example.twitter.mapper;

import com.example.twitter.api.hashtag.FindHashtagPostRequest;
import com.example.twitter.entity.Hashtag;
import com.example.twitter.entity.Hashtag.HashtagBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-18T15:22:17-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class HashtagMapperImpl implements HashtagMapper {

    @Override
    public Hashtag map(FindHashtagPostRequest request) {
        if ( request == null ) {
            return null;
        }

        HashtagBuilder<?, ?> hashtag = Hashtag.builder();

        hashtag.text( request.getText() );

        return hashtag.build();
    }
}
