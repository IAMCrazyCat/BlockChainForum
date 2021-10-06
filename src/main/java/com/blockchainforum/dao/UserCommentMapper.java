package com.blockchainforum.dao;

import com.blockchainforum.entity.UserComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCommentMapper {
    List<UserComment> selectCommentsByUid(int uid);
    UserComment selectById(int cid, int uid, int pid);
    int insertUserComment(int cid, int uid, int pid);
    int updateUserComment(int cid, int uid, int pid, String comment);
    int deleteUserComment(int cid);
}
