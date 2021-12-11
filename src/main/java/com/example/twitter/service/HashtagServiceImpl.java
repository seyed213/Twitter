package com.example.twitter.service;

import com.example.twitter.api.post.PostModel;
import com.example.twitter.entity.Hashtag;
import com.example.twitter.entity.Post;
import com.example.twitter.mapper.PostMapper;
import com.example.twitter.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HashtagServiceImpl implements HashtagService {

    @Autowired
    private HashtagRepository hashtagRepository;


    @Override
    public List<PostModel> findPostByHashtag(String request) throws Exception {

        Hashtag hashtag = hashtagRepository.findByText(request);

        if (hashtag == null) {
            throw new Exception("this hashtag Not Found");
        } else {
            List<PostModel> postModels = new ArrayList<>();
            for (Post post : hashtag.getPosts()) {
                PostMapper.Instance.map2(post);

                postModels.add(PostMapper.Instance.map2(post));
            }

//            hashtag.getPosts().stream().map(PostMapper.Instance::map2).collect(Collectors.toList());

            return postModels;

        }


    }
}
