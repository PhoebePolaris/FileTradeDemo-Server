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
    public User findUserByUid(String uid){
        return userDao.findUserByUid(uid);
    }
}
