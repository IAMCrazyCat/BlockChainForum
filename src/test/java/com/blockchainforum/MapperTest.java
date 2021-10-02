package com.blockchainforum;

import com.blockchainforum.dao.ForumUserMapper;
import com.blockchainforum.dao.PostMapper;
import com.blockchainforum.entity.ForumUser;
import com.blockchainforum.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BlockchainforumApplication.class)
public class MapperTest {

    @Autowired
    private ForumUserMapper forumUserMapper;
    @Autowired
    private PostMapper postMapper;

//    @Test
//    public void testSelectUser(){
//        ForumUser forumUser = forumUserMapper.selectById(123);
//        System.out.println(forumUser);
//    }
//    @Test
//    public void testInsertUser(){
//        ForumUser forumUser = new ForumUser();
//        forumUser.setUname("CrazyCat");
//        forumUser.setPwd("5685678");
//        forumUser.setEmail("ziming111@qq.com");
//        forumUser.setUid(234);
//        forumUser.setIntroduction("fuck you");
//        forumUser.setGender(1);
//        forumUser.setAvatar("http://habitracker.club");
//        forumUser.setCreateTime(new Date(System.currentTimeMillis()));
//
//        int rows = forumUserMapper.insertUser(forumUser);
//        System.out.println(rows);
//        System.out.println(forumUser.getUid());
//    }
//    @Test
//    public void testInsertPost(){
//        Post post = new Post();
//        post.setPid(2);
//        post.setTitle("浮生日记");
//        post.setPost_content("今天是个好日子");
//        post.setStatus(0);
//        post.setUid(123);
//        post.setTopic_time(new Timestamp(System.currentTimeMillis()));
//        post.setThumbs_up(100);
//        post.setTopic_catagory("抽象");
//        post.setViewed_number(0);
//        post.setNice_topic(true);
//
//        int row = postMapper.insertPost(post);
//        System.out.println(row);
//        System.out.println(post);
//    }
    @Test
    public void testUpdateUser(){
        int rows = forumUserMapper.updateUserAvatar(123, "C:\\Users\\YU\\Desktop\\media\\img\\girl.jpg");
        System.out.println(rows);
    }
//    @Test
//    public void testSelectPosts(){
//        List<Post> list = postMapper.selectPosts(123, 10);
//        for(Post post : list) {
//            System.out.println(post);
//        }
//    }
}
