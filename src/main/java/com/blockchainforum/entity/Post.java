package com.blockchainforum.entity;

import java.sql.Timestamp;

public class Post {
    private int pid;
    private int uid;
    private String title;
    private String post_content;
    private int status;
    private Timestamp topic_time;
    private String topic_catagory;
    private int viewed_number;
    private boolean nice_topic;
    private int thumbs_up;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getTopic_time() {
        return topic_time;
    }

    public void setTopic_time(Timestamp topic_time) {
        this.topic_time = topic_time;
    }

    public String getTopic_catagory() {
        return topic_catagory;
    }

    public void setTopic_catagory(String topic_catagory) {
        this.topic_catagory = topic_catagory;
    }

    public int getViewed_number() {
        return viewed_number;
    }

    public void setViewed_number(int viewed_number) {
        this.viewed_number = viewed_number;
    }

    public boolean isNice_topic() {
        return nice_topic;
    }

    public void setNice_topic(boolean nice_topic) {
        this.nice_topic = nice_topic;
    }

    public int getThumbs_up() {
        return thumbs_up;
    }

    public void setThumbs_up(int thumbs_up) {
        this.thumbs_up = thumbs_up;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", post_content='" + post_content + '\'' +
                ", status=" + status +
                ", topic_time=" + topic_time +
                ", topic_catagory='" + topic_catagory + '\'' +
                ", viewed_number=" + viewed_number +
                ", nice_topic=" + nice_topic +
                ", thumbs_up=" + thumbs_up +
                '}';
    }
}