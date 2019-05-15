package com.example.filetrade.dao;

import com.example.filetrade.entity.Upload_log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */
@Repository
public class Upload_logDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //add File_label
    public int add(Upload_log upload_log) {
        return jdbcTemplate.update("INSERT INTO upload_log(file_id,user_id) VALUES (?, ?)",
                upload_log.getFile_id(),upload_log.getUser_id());

    }

    //search
    public List<Upload_log> findUpload_logByUser_id(String user_id){
        List<Upload_log> list = jdbcTemplate.query("SELECT * FROM upload_log WHERE user_id = ?", new Object[]{user_id}, new BeanPropertyRowMapper(Upload_log.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }


    //取消
    public int deleteUpload_logByFile_idAndUser_id(String file_id,String user_id){
        return jdbcTemplate.update("DELETE FROM upload_log WHERE file_id = ? and user_id=?",
                file_id,user_id);
    }
}
