package com.blockchainforum.service;

import com.blockchainforum.dao.PostMapper;
import com.blockchainforum.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;


import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    public List<Post> findPosts(int uid, int offset, int limit) {
        return postMapper.selectPosts(uid, offset, limit);

    }

    public int findPostRows(int uid) {
        return postMapper.selectDiscussionPostRows(uid);
    }

    public List<Post> findAllPosts() { return postMapper.selectAllPosts();}

    public int addPost(Post post) {
        if(post == null) {
            throw new IllegalArgumentException("argument cannot be null");
        }
        //parse html into normal text
        post.setTitle(HtmlUtils.htmlEscape(post.getTitle()));
        post.setPost_content(HtmlUtils.htmlEscape(post.getPost_content()));
        post.setTopic_catagory("no type");
        System.out.println(post);

        return postMapper.insertPost(post);
    }

    public Post findPostById(int id) {
        return postMapper.selectPostById(id);
    }

    public int updateCommmentCount(int id, int commentCount){
        return postMapper.updateCommentCount(id, commentCount);
    }

}
