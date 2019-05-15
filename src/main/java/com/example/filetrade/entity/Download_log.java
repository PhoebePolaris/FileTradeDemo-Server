package com.example.filetrade.entity;

/**
 * Created by lenovo on 2019/5/15.
 */
public class Download_log {private String log_id;
    private String user_id;
    private String file_id;

    public String getFile_id() {
        return file_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    @Override
    public String toString() {
        return "Download_log [log_id=" + log_id + ", file_id="+file_id+", user_id="+user_id + "]";
    }
}
