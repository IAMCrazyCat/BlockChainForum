package com.blockchainforum.service;

import com.blockchainforum.entity.UserComment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserCommentServiceImpl implements UserCommentService{
    public static Map<Integer,UserComment> userCommentMap = new HashMap<>();
    @Override
    public void createUserComment(UserComment comment) {
        userCommentMap.put(comment.getCid(),comment);
    }

    @Override
    public void updateUserComment(int id, UserComment comment) {
        userCommentMap.remove(id);
        comment.setCid(id);
        userCommentMap.put(id,comment);
    }

    @Override
    public void deleteUserComment(int id) {
        userCommentMap.remove(id);
    }

    @Override
    public Collection<UserComment> getUserComments() {
        return userCommentMap.values();
    }
}
