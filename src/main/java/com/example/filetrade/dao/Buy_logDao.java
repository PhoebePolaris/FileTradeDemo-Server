package com.example.filetrade.dao;

import com.example.filetrade.entity.Buy_log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */
@Repository
public class Buy_logDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //add File_label
    public int add(Buy_log buy_log) {
        return jdbcTemplate.update("INSERT INTO buy_log(log_id,file_id,user_id) VALUES (?, ?, ?)",
                buy_log.getLog_id(),buy_log.getFile_id(),buy_log.getUser_id());

    }

    //search
    public List<Buy_log> findBuy_logByUser_id(String user_id){
        List<Buy_log> list = jdbcTemplate.query("SELECT * FROM buy_log WHERE user_id = ?", new Object[]{user_id}, new BeanPropertyRowMapper(Buy_log.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }


    //取消
    public int deleteBuy_logByFile_idAndUser_id(String file_id,String user_id){
        return jdbcTemplate.update("DELETE FROM buy_log WHERE file_id = ? and user_id=?",
                file_id,user_id);

    }

}
