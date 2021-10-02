package com.blockchainforum.service;

import com.blockchainforum.dao.PostMapper;
import com.blockchainforum.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    public List<Post> findPosts(int uid, int limit) {
        return postMapper.selectPosts(uid, limit);
    }

    public int findPostRows(int uid) {
        return postMapper.selectDiscussionPostRows(uid);
    }

}
