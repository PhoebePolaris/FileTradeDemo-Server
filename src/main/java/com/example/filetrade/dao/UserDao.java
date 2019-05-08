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
        return jdbcTemplate.update("INSERT INTO user(uid, name, credit) VALUES (?, ?, ?)",
                user.getUid(),user.getName(),user.getCredit());

    }

    //update
    public int update(User user) {
        return jdbcTemplate.update("UPDATE user SET name = ? , credit = ? WHERE uid=?",
                user.getName(),user.getCredit(),user.getUid());
    }

    //search
    public User findUserByUid(String uid){
        List<User> list = jdbcTemplate.query("SELECT * FROM user WHERE uid = ?", new Object[]{uid}, new BeanPropertyRowMapper(User.class));
        if(list!=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}