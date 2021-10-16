package com.blockchainforum.controller.interceptor;

import com.blockchainforum.entity.ForumUser;
import com.blockchainforum.entity.LoginTicket;
import com.blockchainforum.service.UserService;
import com.blockchainforum.util.CookieUtil;
import com.blockchainforum.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.ForkJoinPool;

@Component
public class LoginTicketInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Autowired
    private HostHolder hostHolder;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ticket = CookieUtil.getValue(request, "ticket");
        System.out.println("ticket is: " + ticket);
        if(ticket != null) {
            LoginTicket loginTicket = userService.findLoginTicket(ticket);
            System.out.println(loginTicket.toString());
            System.out.println("进入");
            if(loginTicket != null && loginTicket.getStatus() == 0 ) {
                ForumUser forumUser = userService.findUserById(loginTicket.getUid());
                System.out.println(forumUser);
                hostHolder.setUser(forumUser);
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        ForumUser forumUser = hostHolder.getUser();
        if(forumUser != null && modelAndView != null) {
            modelAndView.addObject("loginUser", forumUser);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();
    }
}
