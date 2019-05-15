package com.example.filetrade.entity;

/**
 * Created by lenovo on 2019/5/15.
 */
public class File_score {
    private String score_id;
    private String file_id;
    private String from_user_id;
    private int score;

    public String getFile_id() {
        return file_id;
    }

    public String getFrom_user_id() {
        return from_user_id;
    }

    public String getScore_id() {
        return score_id;
    }

    public int getScore() {
        return score;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public void setFrom_user_id(String from_user_id) {
        this.from_user_id = from_user_id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScore_id(String score_id) {
        this.score_id = score_id;
    }

    @Override
    public String toString() {
        return "File_label [score_id=" + score_id + ", file_id="+file_id+", from_user_id="+from_user_id+", score=" + score + "]";
    }
}
