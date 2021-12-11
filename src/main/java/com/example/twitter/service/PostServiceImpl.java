package com.example.twitter.service;

import com.example.twitter.api.post.CreatePostRequest;
import com.example.twitter.api.post.CreatePostResponse;
import com.example.twitter.entity.Hashtag;
import com.example.twitter.entity.Post;
import com.example.twitter.mapper.PostMapper;
import com.example.twitter.repository.HashtagRepository;
import com.example.twitter.repository.PostRepository;
import com.example.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private HashtagRepository hashtagRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public CreatePostResponse create(CreatePostRequest request) throws Exception {

        List<String> hashs = new ArrayList<String>();
        Post post = PostMapper.Instance.map(request);

        BigInteger userExist = userRepository.chekExist(post.getUser().getId());


        if (userExist.equals(BigInteger.valueOf(0))) throw new Exception("user not exist");

        Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
        Matcher mat = MY_PATTERN.matcher(post.getText());
        while (mat.find()) {

            hashs.add(mat.group(1));
        }
        ArrayList<Hashtag> hashtags = new ArrayList<>();

        for (String hashtag : hashs) {

            //چک شود که آیا این هشتگ درپست های قبلی بوده یاخیر؟اگر بوده فقط به آیدی جدید سینک شود وگرنه ساخته شود
            boolean hashExist = hashtagRepository.chekExist(hashtag);

            if (!hashExist) {
                Hashtag newHashtag = new Hashtag();
                newHashtag.setText(hashtag);
                Hashtag createdHashtag = hashtagRepository.save(newHashtag);
                hashtags.add(createdHashtag);
                // add to list
            } else {
                hashtags.add(hashtagRepository.findByText(hashtag));

            }
        }

        post.setHashtag(hashtags);
        Post createdPost = postRepository.save(post);

        CreatePostResponse response = PostMapper.Instance.map(createdPost);


        return response;
    }


}

