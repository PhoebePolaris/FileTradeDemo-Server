package com.example.filetrade.dao;

import com.example.filetrade.entity.File_score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */
@Repository
public class File_scoreDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //add File_label
    public int add(File_score file_score) {
        return jdbcTemplate.update("INSERT INTO file_score(score_id,file_id,from_user_id,score) VALUES (?, ?, ?, ?)",
                file_score.getScore_id(),file_score.getFile_id(),file_score.getFrom_user_id(),file_score.getScore());

    }

    //update
    public int update(File_score file_score) {
        return jdbcTemplate.update("UPDATE file_score SET score = ?  WHERE file_id=? and from_user_id=?",
                file_score.getScore(),file_score.getFile_id(),file_score.getFrom_user_id());
    }

    //search
    public List<File_score> findFile_scorelByFile_id(String file_id){
        List<File_score> list = jdbcTemplate.query("SELECT * FROM file_score WHERE file_id = ?", new Object[]{file_id}, new BeanPropertyRowMapper(File_score.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    //search
    public File_score findFile_scorelByFile_idAndUser_id(String file_id,String user_id){
        List<File_score> list = jdbcTemplate.query("SELECT * FROM file_score WHERE file_id = ? and from_user_id=?", new Object[]{file_id,user_id}, new BeanPropertyRowMapper(File_score.class));
        if(list!=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

}
