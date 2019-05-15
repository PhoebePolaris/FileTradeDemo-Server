package com.example.filetrade.entity;

public class User {
    private String user_id;
    private String phone_num;
    //密码为16位
    private String password;
    private String user_name ;
    private int credit;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String uid) {
        this.user_id = uid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String name) {
        this.user_name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getLabel_id() {
//        return label_id;
//    }
//
//    public void setLabel_id(String label_id) {
//        this.label_id = label_id;
//    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", phone_num="+phone_num+", password="+password+", user_name=" + user_name + ", credit=" + credit + "]";
    }
}
