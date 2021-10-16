package com.blockchainforum.util;

import com.blockchainforum.entity.ForumUser;
import org.springframework.stereotype.Component;

import java.util.concurrent.ForkJoinPool;

@Component
public class HostHolder {

    private ThreadLocal<ForumUser> forumusers = new ThreadLocal<>();

    public void setUser(ForumUser forumUser) {
        forumusers.set(forumUser);
    }
    public ForumUser getUser() {
        return forumusers.get();
    }

    public void clear() {
        forumusers.remove();
    }
}
