package com.blockchainforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/title")
    @ResponseBody
    public String showdemo(){
        return "This is a Blockchain forum";
    }
}
