package com.blockchainforum.service;

import com.blockchainforum.dao.ForumUserMapper;
import com.blockchainforum.dao.LoginTicketMapper;
import com.blockchainforum.entity.ForumUser;
import com.blockchainforum.entity.LoginTicket;
import com.blockchainforum.util.CommunityConstant;
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
public class UserService implements CommunityConstant {
    @Autowired
    private ForumUserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

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
        System.out.println("register"+ forumUser.getPwd());
        System.out.println("register" + forumUser.getSalt());
        forumUser.setPwd(CommunityUtil.md5(forumUser.getPwd() + forumUser.getSalt()));
        System.out.println("register"+ forumUser.getPwd());
        forumUser.setCreateTime(new Date(System.currentTimeMillis()));
        forumUser.setIntroduction("Nothing");
        forumUser.setActivationCode(CommunityUtil.generateUUID());
        forumUser.setStatus(0);


        userMapper.insertUser(forumUser);
        int uid = userMapper.selectByEmail(forumUser.getEmail()).getUid();
        //activation email
        Context context = new Context();
        context.setVariable("email", forumUser.getEmail());
        //http://localhost:8080/community/activation/101/code
        String url = domain + contextPath+"/activation/" + uid +  '/' + forumUser.getActivationCode();
        context.setVariable("url",url);
        System.out.println(url);
        String content = templateEngine.process("mail/activation", context);
        mailClient.sendMail(forumUser.getEmail(), "Activate account", content);

        return map;
    }

    public int activation(int userId, String code) {
        ForumUser forumUser = userMapper.selectById(userId);
//        System.out.println(forumUser.getActivationCode());
//        System.out.println(forumUser);
        if(forumUser.getStatus() == 1){
            return ACTIVATION_REPEAT;
        } else if(forumUser.getActivationCode().equals(code)){
            userMapper.updateUserStatus(userId, 1);
            return ACTIVATION_SUCCESS;
        } else {
            return ACTIVATION_FAILURE;
        }
    }

    public Map<String, Object> login(String username, String password, int expiredSeconds) {
        Map<String, Object> map = new HashMap<>();
        if(StringUtils.isEmpty(username)) {
            map.put("username", "username cannot be null");
            return map;
        }
        ForumUser forumUser = userMapper.selectByName(username);
        if(forumUser == null) {
            map.put("usernameMsg", "This account does not exist");
            return map;
        }
        if(forumUser.getStatus() == 1) {
            map.put("usernameMsg", "This account has not been activated");
            return map;
        }
        System.out.println("login"+ password);
        System.out.println("login" + forumUser.getSalt());
        password = CommunityUtil.md5(password + forumUser.getSalt());
        System.out.println("login"+ password);
        if(! forumUser.getPwd().equals(password)) {
            map.put("passwordMsg", "Password is not correct");
            return map;
        }
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUid(forumUser.getUid());
        loginTicket.setTicket(CommunityUtil.generateUUID());
        loginTicket.setStatus(1);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + expiredSeconds * 1000));
        loginTicketMapper.insertLoginTicket(loginTicket);

        map.put("ticket", loginTicket.getTicket());
        return map;
    }
}
