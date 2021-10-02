package com.blockchainforum.dao;

import com.blockchainforum.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> selectPosts(int uid, int limit);
    int selectDiscussionPostRows(@Param("uid") int uid);
    int insertPost(Post post);
    int updatePostComment(int uid, int pid, String content);
    int updatePostNiceTopic(int uid, int pid, boolean nice_topic);
    int updatePostStatus(int uid, int pid, int status);
}
