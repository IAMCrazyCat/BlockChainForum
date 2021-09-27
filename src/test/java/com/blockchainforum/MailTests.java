package com.blockchainforum;

import com.blockchainforum.util.MailClient;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BlockchainformApplication.class)
public class MailTests {
    @Autowired
    private MailClient mailClient;
    @Test
    public void testTextMail(){
        mailClient.sendMail("yuruojie111@qq.com","Welcome to Blockchain Forum","This is a Blockchain Forum!");

    }
}
