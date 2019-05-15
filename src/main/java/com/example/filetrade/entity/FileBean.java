package com.example.filetrade.entity;

public class FileBean {

    public static String URL = "C:\\Users\\84622\\Desktop\\storage\\";

    private String creator_id;
    private String file_id;
    private String size;
    private String file_title;
    private String file_type;
    private String creation_time;
    private int credit;
    private double score;

    public String getCreation_time() {
        return creation_time;
    }

    public String getCreator_id() {
        return creator_id;
    }

    public String getFile_id() {
        return file_id;
    }

    public String getFile_title() {
        return file_title;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public void setCreator_id(String creator_id) {
        this.creator_id = creator_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public void setFile_title(String file_title) {
        this.file_title = file_title;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public double getScore() {
        return score;
    }

    public String getSize() {
        return size;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getURL(){
        return URL + file_id+"."+file_type;
    }

    public static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;

        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            return String.format("%.1f MB", (float) size / mb);
        } else if (size >= kb) {
            return String.format("%.1f KB", (float) size / kb);
        } else
            return String.format("%d B", size);
    }
}
