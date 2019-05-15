package com.example.filetrade.dao;

import com.example.filetrade.entity.Download_log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */
@Repository
public class Download_logDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //add File_label
    public int add(Download_log download_log) {
        return jdbcTemplate.update("INSERT INTO download_log(log_id,file_id,user_id) VALUES (?, ?, ?)",
                download_log.getLog_id(),download_log.getFile_id(),download_log.getUser_id());

    }

    //search
    public List<Download_log> findDownload_logByUser_id(String user_id){
        List<Download_log> list = jdbcTemplate.query("SELECT * FROM download_log WHERE user_id = ?", new Object[]{user_id}, new BeanPropertyRowMapper(Download_log.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }


    //取消
    public int deleteDownload_logByFile_idAndUser_id(String file_id,String user_id){
        return jdbcTemplate.update("DELETE FROM download_log WHERE file_id = ? and user_id=?",
                file_id,user_id);
    }
}
