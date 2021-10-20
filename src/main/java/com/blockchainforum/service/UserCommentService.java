package com.blockchainforum.service;

import com.blockchainforum.entity.UserComment;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface UserCommentService {
    public abstract void createUserComment(UserComment comment);
    public abstract void updateUserComment(int id,UserComment comment);
    public abstract void deleteUserComment(int id);
    public abstract List<UserComment> getUserComments(int uid);
}
