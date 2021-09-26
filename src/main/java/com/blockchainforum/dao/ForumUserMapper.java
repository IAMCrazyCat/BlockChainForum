package com.blockchainforum.dao;

import com.blockchainforum.entity.ForumUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ForumUserMapper {
    ForumUser selectById(int uid);
    ForumUser selectByName(String name);

    int insertUser(ForumUser forumUser);
    int updateUserName(int uid, String name);
}
