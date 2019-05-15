package com.example.filetrade.dao;

import com.example.filetrade.entity.Collect_log;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */
@Repository
public class Collect_logDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //add File_label
    public int add(Collect_log collect_log) {
        return jdbcTemplate.update("INSERT INTO collect_log(log_id,file_id,user_id) VALUES (?, ?, ?)",
                collect_log.getLog_id(),collect_log.getFile_id(),collect_log.getUser_id());

    }

    //search
    public List<Collect_log> findCollect_logByUser_id(String user_id){
        List<Collect_log> list = jdbcTemplate.query("SELECT * FROM collect_log WHERE user_id = ?", new Object[]{user_id}, new BeanPropertyRowMapper(Collect_log.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }


    //取消收藏
    public int deleteCollect_logByFile_idAndUser_id(String file_id,String user_id){
        return jdbcTemplate.update("DELETE FROM collect_log WHERE file_id = ? and user_id=?",
                file_id,user_id);

    }
}
