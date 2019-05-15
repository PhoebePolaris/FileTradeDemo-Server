package com.example.filetrade.entity;

/**
 * Created by lenovo on 2019/5/15.
 */
public class User_label {
    private String user_id;
    private String label_1;
    private String label_2;
    private String label_3;
    private String label_4;
//    public String getLabel_id() {
//        return label_id;
//    }

    public String getUser_id() {
        return user_id;
    }

    public String getLabel_1() {
        return label_1;
    }

    public String getLabel_3() {
        return label_3;
    }

    public String getLabel_2() {
        return label_2;
    }

    public String getLabel_4() {
        return label_4;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
//
//    public void setLabel_id(String label_id) {
//        this.label_id = label_id;
//    }

    public void setLabel_1(String label) {
        this.label_1 = label;
    }

    public void setLabel_2(String label_2) {
        this.label_2 = label_2;
    }

    public void setLabel_3(String label_3) {
        this.label_3 = label_3;
    }

    public void setLabel_4(String label_4) {
        this.label_4 = label_4;
    }

    @Override
    public String toString() {
        return "User_Label [ user_id="+user_id + ", label_1="+label_1+", label_2="+label_2+", label_3="+label_3+", label_4="+label_4+" ]";
    }
}
