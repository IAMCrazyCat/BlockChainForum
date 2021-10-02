package com.blockchainforum.service;

import com.blockchainforum.dao.ForumUserMapper;
import com.blockchainforum.entity.ForumUser;
import com.blockchainforum.util.CommunityUtil;
import com.blockchainforum.util.MailClient;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.util.StringUtils;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private ForumUserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${community.path.domain}")
    private String domain;
    @Value("${server.servlet.context-path}")
    private String contextPath;

    public ForumUser findUserById(int uid){
        return userMapper.selectById(uid);
    }

    public Map<String, Object> register(ForumUser forumUser) {
        Map<String, Object> map = new HashMap<>();

        //NULL
        if(forumUser == null) {
            throw new IllegalArgumentException("The parameter can not be null");
        }
        if(StringUtils.isEmpty(forumUser.getUname())) {
            map.put("userNameMsg", "username can not be null");
        }
        if(StringUtils.isEmpty(forumUser.getPwd())) {
            map.put("passwordMsg", "password can not be null");
        }
        if(StringUtils.isEmpty(forumUser.getEmail())){
            map.put("emailMsg", "email can not be null");
        }

        //verify account
        ForumUser u = userMapper.selectByName(forumUser.getUname());
        if(u != null){
            map.put("userNameMsg", "Username already exist");
            System.out.println("Username already exist");
            return map;
        }

        //verify email
        u = userMapper.selectByEmail(forumUser.getEmail());
        if(u != null){
            map.put("emailMsg", "Email already exist");
            return map;
        }

        //register
        forumUser.setSalt(CommunityUtil.generateUUID().substring(0,5));
        forumUser.setPwd(CommunityUtil.md5(forumUser.getPwd() + forumUser.getSalt()));
        forumUser.setCreateTime(new Date(System.currentTimeMillis()));
        forumUser.setIntroduction("Nothing");
        forumUser.setActivationCode(CommunityUtil.generateUUID());
        userMapper.insertUser(forumUser);

        //activation email
        Context context = new Context();
        context.setVariable("email", forumUser.getEmail());
        //http://localhost:8080/community/activation/101/code
        String url = domain + contextPath+"/activation" + forumUser.getUid();
        String content = templateEngine.process("/mail/activation", context);
        mailClient.sendMail(forumUser.getEmail(), "Activate account", content);

        return map;
    }
}
