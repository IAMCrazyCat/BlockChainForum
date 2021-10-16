package com.blockchainforum;

import com.blockchainforum.dao.ForumUserMapper;

import com.blockchainforum.dao.LoginTicketMapper;
import com.blockchainforum.dao.MessageMapper;
import com.blockchainforum.entity.ForumUser;
import com.blockchainforum.entity.LoginTicket;
import com.blockchainforum.entity.Message;
import org.checkerframework.checker.units.qual.A;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Date;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BlockchainforumApplication.class)
public class MapperTest {

    @Autowired
    private ForumUserMapper forumUserMapper;
    @Autowired

    private LoginTicketMapper loginTicketMapper;
    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void testUpdateUser(){
        int rows = forumUserMapper.updateUserAvatar(123, "C:\\Users\\YU\\Desktop\\media\\img\\girl.jpg");
        System.out.println(rows);
    }

    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUid(1001);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket() {
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("abc", 1);
        loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
    }

    @Test
    public void testSelectLetters() {
        List<Message> list = messageMapper.selectConversations(111,0, 10);
        for (Message message : list){
            System.out.println(message);
        }
    }

}
