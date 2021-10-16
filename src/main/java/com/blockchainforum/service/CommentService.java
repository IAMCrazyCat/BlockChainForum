package com.blockchainforum.service;

import com.blockchainforum.dao.UserCommentMapper;
import com.blockchainforum.entity.UserComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private UserCommentMapper userCommentMapper;

    @Autowired
    private PostService postService;
    public List<UserComment> findCommentsByPost(int pid, int offset, int limit){
        return userCommentMapper.selectCommentByPost(pid, offset, limit);
    }

    public int findCommentCount(int pid){
        return userCommentMapper.selectCountByPost(pid);
    }
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int addComment(UserComment userComment) {
        if(userComment == null){
            throw new IllegalArgumentException("parameter can not be null");
        }
        userComment.setComment_content(HtmlUtils.htmlEscape(userComment.getComment_content()));
        int rows = userCommentMapper.insertUserComment(userComment);
        int count = userCommentMapper.selectCountByPost(userComment.getPid());
        postService.updateCommmentCount(userComment.getPid(), count);

        return rows;
    }
}
