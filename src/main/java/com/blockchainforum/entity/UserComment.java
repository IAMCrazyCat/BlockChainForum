package com.blockchainforum.entity;

import java.sql.Timestamp;

public class UserComment {
    private int cid;
    private int uid;
    private int pid;
    private int target_id;
    private String comment_content;
    int status;
    Timestamp createTime;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public int getTarget_id() {
        return target_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserComment{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", target_id=" + target_id +
                ", comment_content='" + comment_content + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}