package com.example.filetrade.entity;

/**
 * Created by lenovo on 2019/5/15.
 */
public class User_label {
    private String user_id;
    private String label;
//    public String getLabel_id() {
//        return label_id;
//    }

    public String getUser_id() {
        return user_id;
    }

    public String getLabel() {
        return label;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
//
//    public void setLabel_id(String label_id) {
//        this.label_id = label_id;
//    }

    public void setLabel(String label) {
        this.label = label;
    }
    @Override
    public String toString() {
        return "User_Label [ user_id="+user_id + ", label="+label+" ]";
    }
}
