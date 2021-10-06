package com.blockchainforum.controller;

import com.blockchainforum.entity.UserComment;
import com.blockchainforum.service.UserCommentService;
import com.blockchainforum.service.UserCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private UserCommentServiceImpl userCommentService;

    @RequestMapping(path = "/comment", method = RequestMethod.GET)
    public String getComment(int uid,Model model){
        List<UserComment> comments = userCommentService.getUserComments(uid);
        model.addAttribute("comments",comments);
        return "/comment";
    }
}
