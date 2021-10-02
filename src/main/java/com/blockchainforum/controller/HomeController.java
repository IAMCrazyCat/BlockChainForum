package com.blockchainforum.controller;

import com.blockchainforum.entity.ForumUser;
import com.blockchainforum.entity.Post;
import com.blockchainforum.service.PostService;
import com.blockchainforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model){
        List<Post> list = postService.findPosts(123, 10);
        List<Map<String, Object>> posts = new ArrayList();
        if(list != null){
            for(Post post : list){
                Map<String, Object> map = new HashMap<>();
                map.put("post",post);
                ForumUser forumUser = userService.findUserById(post.getUid());
                map.put("forumUser", forumUser);
                posts.add(map);
            }
        }
        model.addAttribute("posts", posts);
        return "/index";
    }
}
