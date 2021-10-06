package com.blockchainforum.util;

import org.springframework.util.DigestUtils;
import org.thymeleaf.util.StringUtils;

import java.util.UUID;

public class CommunityUtil {

    //generate random string
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    //MD5 encrypt
    public static String md5(String key) {
        if(StringUtils.isEmpty(key)){
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
