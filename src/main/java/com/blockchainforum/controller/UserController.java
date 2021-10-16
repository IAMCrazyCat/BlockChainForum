package com.blockchainforum.controller;

import com.blockchainforum.annotation.LoginRequired;
import com.blockchainforum.entity.ForumUser;
import com.blockchainforum.service.UserService;
import com.blockchainforum.util.CommunityUtil;
import com.blockchainforum.util.HostHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/user")
public class UserController {

    private static  final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Value("@{community.path.upload}")
    private String uploadPath;

    @Value("@{community.path.domain}")
    private String domain;

    @Value("@{server.servlet.context-path}")
    private String contextPath;

    @Autowired
    private UserService userService;

    @Autowired
    private HostHolder hostHolder;
    @LoginRequired
    @RequestMapping(path = "/setting", method = RequestMethod.GET)
    public String getSettingPage() {
        return "setting_yrj";
    }

    @LoginRequired
    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String uploadAvatar(MultipartFile avatarImage, Model model) {
        if(avatarImage == null) {
            model.addAttribute("error", "No file uploaded");
            return "setting_yrj";
        }

        String fileName = avatarImage.getOriginalFilename();
        System.out.println(fileName);
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        if(StringUtils.isEmpty(suffix)) {
            model.addAttribute("error", "Incorrect Format!");
            return "setting_yrj";
        }

        fileName = CommunityUtil.generateUUID() + suffix;
        File dest = new File(new File("/picture").getAbsolutePath() + "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            avatarImage.transferTo(dest);
        } catch (IOException e) {
            logger.error("upload failed" + e.getMessage());
            throw new RuntimeException("upload failed");
        }

        //update avatar path
        //http://localhost:8080/community/user/avatar/xxxx.png
        ForumUser forumUser = hostHolder.getUser();
        String avatarURL = "http://123.56.59.240:8080/avatar" + "/" + fileName;
        userService.updateAvatar(forumUser.getUid(), avatarURL);

        return "redirect:/index";
    }
    @RequestMapping(path = "/avatar/{fileName}", method = RequestMethod.GET)
    public void getAvatar(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        fileName = uploadPath + "/" + fileName;
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        response.setContentType("image/" + suffix);
        try (
                FileInputStream fis = new FileInputStream(fileName);
                OutputStream os = response.getOutputStream();
                ){
            byte[] buffer = new byte[1024];
            int b = 0;
            while((b = fis.read(buffer)) != -1) {
                os.write(buffer, 0, b);
            }
        } catch (IOException e) {
            logger.error("fail to load image" + e.getMessage());
        }
    }
}
