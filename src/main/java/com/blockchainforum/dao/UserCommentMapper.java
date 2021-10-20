package com.blockchainforum.dao;

import com.blockchainforum.entity.UserComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCommentMapper {

    List<UserComment> selectCommentByPost(int pid, int offset, int limit);
    int selectCountByPost(int pid);
    int insertUserComment(UserComment userComment);
    int updateUserComment(int uid, int pid, int cid, String comment);
  
    int deleteUserComment(int cid);
    List<UserComment> selectCommentsByUid(int uid);
}
