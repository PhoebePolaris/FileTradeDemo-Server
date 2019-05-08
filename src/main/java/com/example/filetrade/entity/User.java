package com.example.filetrade.entity;

public class User {
    private String uid;
    private String name ;
    private int credit;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "User [uid=" + uid + ", name=" + name + ", credit=" + credit + "]";
    }
}
