package com.example.filetrade.service;

import com.example.filetrade.dao.Buy_logDao;
import com.example.filetrade.entity.Buy_log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */
@Service
public class Buy_logService {
    @Autowired
    private Buy_logDao buy_logDao;
    //add
    public int add(Buy_log buy_log) {
        return buy_logDao.add(buy_log);
    }

    //search
    public List<Buy_log> findBuy_logByUser_id(String user_id){
        return buy_logDao.findBuy_logByUser_id(user_id);
    }

    public int deleteBuy_logByFile_idAndUser_id(String file_id,String user_id){
        return buy_logDao.deleteBuy_logByFile_idAndUser_id(file_id,user_id);
    }
}
