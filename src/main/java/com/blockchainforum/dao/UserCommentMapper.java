package com.blockchainforum.dao;

import com.blockchainforum.entity.UserComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCommentMapper {
    UserComment selectById(int uid, int pid, int cid);
    int insertUserComment(UserComment userComment);
    int updateUserComment(int uid, int pid, int cid, String comment);
}
