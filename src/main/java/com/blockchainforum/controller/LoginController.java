package com.blockchainforum.controller;

import com.blockchainforum.entity.ForumUser;
import com.blockchainforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.concurrent.ForkJoinPool;

@Controller
public class LoginController {
    @RequestMapping(path="/register", method = RequestMethod.GET)
    public String getRegisterPage() {return "/site/register";}

    @Autowired
    private UserService userService;

    @RequestMapping(path="/register", method = RequestMethod.POST)
    public String register(Model model, ForumUser forumUser) {
        Map<String, Object> map = userService.register(forumUser);
        if(map == null || map.isEmpty()) {
            model.addAttribute("msg", "Successfully send an email to you");
            model.addAttribute("target", "/index");
            return "/site/operate-result";
        }else{
            model.addAttribute("userNameMsg", map.get("userNameMsg"));
            model.addAttribute("passwordMsg", map.get("passwordMsg"));
            model.addAttribute("emailMsg", map.get("emailMsg"));
            return "/site/register";
        }
    }
}
