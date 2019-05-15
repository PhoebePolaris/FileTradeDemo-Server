package com.example.filetrade.service;

import com.example.filetrade.dao.UserDao;
import com.example.filetrade.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    //add
    public int add(User user) {
        return userDao.add(user);
    }

    //update
    public int update(User user) {
        return userDao.update(user);
    }

    //search
    public User findUserByUser_id(String user_id){
        return userDao.findUserByUser_id(user_id);
    }

    //login
    public String login(User user){
        return userDao.login(user);
    }

    //修改信息
    public int updateOther(User user){return userDao.updateOther(user);}
}
