package com.example.filetrade.dao;

import com.example.filetrade.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //add user
    public int add(User user) {
        return jdbcTemplate.update("INSERT INTO user(user_id,phone_num,password,user_name,credit) VALUES (?, ?, ?, ?, ?)",
                user.getUser_id(),user.getPhone_num(),user.getPassword(),user.getUser_name(),user.getCredit());

    }

    //update
    public int update(User user) {
        return jdbcTemplate.update("UPDATE user SET user_name = ? , credit = ? WHERE user_id=?",
                user.getUser_name(),user.getCredit(),user.getUser_id());
    }

    //search
    public User findUserByUser_id(String user_id){
        List<User> list = jdbcTemplate.query("SELECT * FROM user WHERE user_id = ?", new Object[]{user_id}, new BeanPropertyRowMapper(User.class));
        if(list!=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}