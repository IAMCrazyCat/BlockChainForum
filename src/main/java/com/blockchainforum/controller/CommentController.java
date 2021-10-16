package com.blockchainforum.controller;

import com.blockchainforum.entity.UserComment;

import com.blockchainforum.service.CommentService;
import com.blockchainforum.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path = "/add/{pid}", method = RequestMethod.POST)
    public String addComment(@PathVariable("pid") int pid, UserComment userComment) {
        userComment.setUid(hostHolder.getUser().getUid());
        userComment.setStatus(0);
        userComment.setCreateTime(new Timestamp(System.currentTimeMillis()));
        commentService.addComment(userComment);

        return "redirect:/post/detail/" + pid;
    }
}
