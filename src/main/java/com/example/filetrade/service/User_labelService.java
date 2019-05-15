package com.example.filetrade.service;

import com.example.filetrade.dao.User_labelDao;
import com.example.filetrade.entity.User_label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2019/5/15.
 */
@Service
public class User_labelService {
    @Autowired
    private User_labelDao user_labelDao;

    //add
    public int add(User_label user_label) {
        return user_labelDao.add(user_label);
    }

    //update
    public int update(User_label user_label) {
        return user_labelDao.update(user_label);
    }

    //search
    public User_label findUser_labelByUser_id(String user_id){
        return user_labelDao.findUser_labelByUser_id(user_id);
    }
}
