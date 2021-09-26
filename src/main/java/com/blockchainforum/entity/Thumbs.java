package com.blockchainforum.entity;

public class Thumbs {
    private int uid;
    private int pid;
    private int tid;

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

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Thumbs{" +
                "uid=" + uid +
                ", pid=" + pid +
                ", tid=" + tid +
                '}';
    }
}
