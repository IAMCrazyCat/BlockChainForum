package com.blockchainforum;

import com.blockchainforum.dao.ForumUserMapper;
import com.blockchainforum.entity.ForumUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BlockchainformApplication.class)
public class MapperTest {

    @Autowired
    private ForumUserMapper forumUserMapper;

    @Test
    public void testSelectUser(){
        ForumUser forumUser = forumUserMapper.selectById(123);
        System.out.println(forumUser);
    }
}
