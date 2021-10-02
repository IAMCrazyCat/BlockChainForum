package com.blockchainforum.service;

import com.blockchainforum.entity.UserComment;

import java.util.Collection;

public interface UserCommentService {
    public abstract void createUserComment(UserComment comment);
    public abstract void updateUserComment(int id,UserComment comment);
    public abstract void deleteUserComment(int id);
    public abstract Collection<UserComment> getUserComments();
}
