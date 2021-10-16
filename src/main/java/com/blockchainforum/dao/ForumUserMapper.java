package com.blockchainforum.dao;

import com.blockchainforum.entity.ForumUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ForumUserMapper {
    ForumUser selectById(int uid);
    ForumUser selectByName(String name);
    ForumUser selectByEmail(String email);

    int insertUser(ForumUser forumUser);

    int updateUserName(int uid, String uname);
    int updateUserEmail(int uid, String email);
    int updateUserPwd(int uid, String pwd);
    int updateUserGender(int uid, int gender);
    int updateUserIntroduction(int uid, String introduction);

    int updateUserStatus(int uid, int status);

    int updateUserAvatar(int uid, String avatar);
}
