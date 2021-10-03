package com.blockchainforum.dao;

import com.blockchainforum.entity.UserComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCommentMapper {
    UserComment selectById(int cid, int uid, int pid);
    int insertUserComment(int cid, int uid, int pid);
    int updateUserComment(int cid, int uid, int pid, String comment);
    int deleteUserComment(int cid, int uid, int pid);
}
