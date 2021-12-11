package com.example.twitter.mapper;

import com.example.twitter.api.hashtag.HashtagModel;
import com.example.twitter.api.hashtag.HashtagModel.HashtagModelBuilder;
import com.example.twitter.api.post.CreatePostRequest;
import com.example.twitter.api.post.CreatePostResponse;
import com.example.twitter.api.post.CreatePostResponse.CreatePostResponseBuilder;
import com.example.twitter.api.post.PostModel;
import com.example.twitter.api.post.PostModel.PostModelBuilder;
import com.example.twitter.api.user.UserModel;
import com.example.twitter.entity.Hashtag;
import com.example.twitter.entity.Post;
import com.example.twitter.entity.Post.PostBuilder;
import com.example.twitter.entity.User;
import com.example.twitter.entity.User.UserBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-18T15:22:17-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post map(CreatePostRequest request) {
        if ( request == null ) {
            return null;
        }

        PostBuilder<?, ?> post = Post.builder();

        post.text( request.getText() );
        post.user( userModelToUser( request.getUser() ) );

        return post.build();
    }

    @Override
    public CreatePostResponse map(Post post) {
        if ( post == null ) {
            return null;
        }

        CreatePostResponseBuilder createPostResponse = CreatePostResponse.builder();

        createPostResponse.id( post.getId() );
        createPostResponse.text( post.getText() );
        createPostResponse.hashtag( hashtagListToHashtagModelArrayList( post.getHashtag() ) );

        return createPostResponse.build();
    }

    @Override
    public PostModel map2(Post post) {
        if ( post == null ) {
            return null;
        }

        PostModelBuilder postModel = PostModel.builder();

        postModel.id( post.getId() );
        postModel.text( post.getText() );

        return postModel.build();
    }

    protected User userModelToUser(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserBuilder<?, ?> user = User.builder();

        user.id( userModel.getId() );

        return user.build();
    }

    protected HashtagModel hashtagToHashtagModel(Hashtag hashtag) {
        if ( hashtag == null ) {
            return null;
        }

        HashtagModelBuilder hashtagModel = HashtagModel.builder();

        hashtagModel.text( hashtag.getText() );

        return hashtagModel.build();
    }

    protected ArrayList<HashtagModel> hashtagListToHashtagModelArrayList(List<Hashtag> list) {
        if ( list == null ) {
            return null;
        }

        ArrayList<HashtagModel> arrayList = new ArrayList<HashtagModel>();
        for ( Hashtag hashtag : list ) {
            arrayList.add( hashtagToHashtagModel( hashtag ) );
        }

        return arrayList;
    }
}
