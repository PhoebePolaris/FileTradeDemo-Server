package com.example.filetrade.dao;

import com.example.filetrade.entity.User_label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */

@Repository
public class User_labelDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //add user_label
    public int add(User_label user_label) {
        return jdbcTemplate.update("INSERT INTO user_label(user_id,label_1,label_2,label_3,label_4) VALUES (?, ?, ?, ?, ?)",
               user_label.getUser_id(),user_label.getLabel_1(),user_label.getLabel_2(),user_label.getLabel_3(),user_label.getLabel_4());

    }

    //update
    public int update(User_label user_label) {
        return jdbcTemplate.update("UPDATE user_label SET label_1 = ?,label_2=?,label_3=?,label_4=?  WHERE user_id=?",
                user_label.getLabel_1(),user_label.getLabel_2(),user_label.getLabel_3(),user_label.getLabel_4(),user_label.getUser_id());
    }

    //search
    public User_label findUser_labelByUser_id(String user_id){
        List<User_label> list = jdbcTemplate.query("SELECT * FROM user_label WHERE user_id = ?", new Object[]{user_id}, new BeanPropertyRowMapper(User_label.class));
        if(list!=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}
