package com.blockchainforum.controller;

import com.blockchainforum.entity.ForumUser;
import com.blockchainforum.entity.Page;
import com.blockchainforum.entity.Post;
import com.blockchainforum.entity.UserComment;
import com.blockchainforum.service.CommentService;
import com.blockchainforum.service.PostService;
import com.blockchainforum.service.UserService;
import com.blockchainforum.util.CommunityUtil;
import com.blockchainforum.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;
    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addPost(String title, String content) {
        ForumUser forumUser = hostHolder.getUser();
        if(forumUser == null) {
            return CommunityUtil.getJSONString(403, "You should loin before sending a post.");
        }
        Post post = new Post();
        post.setUid(forumUser.getUid());
        post.setTitle(title);
        post.setPost_content(content);
        post.setTopic_time(new Timestamp(System.currentTimeMillis()));
        postService.addPost(post);

        return CommunityUtil.getJSONString(0, "success");
    }
    @RequestMapping(path = "/detail/{pid}", method = RequestMethod.GET)
    public String getPost(@PathVariable("pid") int pid, Model model, Page page) {
        Post post = postService.findPostById(pid);
        System.out.println(post);
        model.addAttribute("post", post);
        ForumUser forumUser = userService.findUserById(post.getUid());
        model.addAttribute("user", forumUser);

        page.setLimit(5);
        page.setPath("/post/detail/"+pid);
        page.setRows(post.getCount());

        List<UserComment> commentList = commentService.findCommentsByPost(post.getPid(), page.getOffset(), page.getLimit());
        List<Map<String, Object>> commentVoList = new ArrayList<>();
        if(commentList != null) {
            for(UserComment comment : commentList){
                Map<String, Object> commentVo = new HashMap<>();
                commentVo.put("comment", comment);
                commentVo.put("user", userService.findUserById(comment.getUid()));

                commentVoList.add(commentVo);
            }
        }

        model.addAttribute("comments", commentVoList);
        return "site/discuss-detail_yrj";
    }
}
