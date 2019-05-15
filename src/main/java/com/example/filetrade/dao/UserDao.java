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

    //update，更新积分
    public int update(User user) {
        return jdbcTemplate.update("UPDATE user SET  credit = ? WHERE user_id=?",
                user.getCredit(),user.getUser_id());
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

    //login
    public String login(User user) {
        List<User> list = jdbcTemplate.query("SELECT * FROM user WHERE phone_num = ?", new Object[]{user.getPhone_num()}, new BeanPropertyRowMapper(User.class));
        if(list!=null && list.size()>0){
            User s= list.get(0);
            if(user.getPassword().equals(s.getPassword())){
                return s.toString();
            }
            else{
                return "密码错误！";
            }
        }else{
            return "用户不存在！";
        }
    }

    //修改信息
    public int updateOther(User user) {
        return jdbcTemplate.update("UPDATE user SET password = ?,user_name=?,phone_num=?  WHERE user_id=?",
                user.getPassword(),user.getUser_name(),user.getPhone_num(),user.getUser_id());
    }

}