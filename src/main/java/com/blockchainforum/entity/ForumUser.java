package com.blockchainforum.entity;

import java.sql.Date;

public class ForumUser {
    //field
    private int uid;
    private String pwd;
    private String gender;
    private Date createTime;
    private String email;
    private String introduction;
    private String avatar;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Forumuser{" +
                "uid=" + uid +
                ", pwd='" + pwd + '\'' +
                ", gender='" + gender + '\'' +
                ", createTime=" + createTime +
                ", email='" + email + '\'' +
                ", introduction='" + introduction + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
