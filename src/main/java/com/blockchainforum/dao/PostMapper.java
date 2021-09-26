package com.blockchainforum.dao;

import com.blockchainforum.entity.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    Post selectById(int uid, int pid);
    int insertPost(Post post);
    int updatePostComment(int uid, int pid, String content);
    int updatePostComment(int uid, int pid, boolean nice_topic);
    int updatePostStatus(int uid, int pid, int status);
}
