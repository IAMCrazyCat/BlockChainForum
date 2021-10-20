package com.blockchainforum.service;

import com.blockchainforum.dao.UserCommentMapper;
import com.blockchainforum.entity.UserComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserCommentServiceImpl implements UserCommentService{
    //public static Map<Integer,UserComment> userCommentMap = new HashMap<>();

    @Autowired
    private UserCommentMapper userCommentMapper;

    @Override
    public void createUserComment(UserComment comment) {
        userCommentMapper.insertUserComment(comment);
    }

    @Override
    public void updateUserComment(int id, UserComment comment) {
        userCommentMapper.deleteUserComment(id);
        comment.setCid(id);
        userCommentMapper.insertUserComment(comment);
    }

    @Override
    public void deleteUserComment(int id) {
        userCommentMapper.deleteUserComment(id);
    }

    @Override
    public List<UserComment> getUserComments(int uid) {
        return userCommentMapper.selectCommentsByUid(uid);
    }
}
