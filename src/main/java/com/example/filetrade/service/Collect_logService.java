package com.example.filetrade.service;

import com.example.filetrade.dao.Collect_logDao;
import com.example.filetrade.entity.Collect_log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */
@Service
public class Collect_logService {
    @Autowired
    private Collect_logDao collect_logDao;
    //add
    public int add(Collect_log collect_log) {
        return collect_logDao.add(collect_log);
    }

    //search
    public List<Collect_log> findCollect_logByUser_id(String user_id){
        return collect_logDao.findCollect_logByUser_id(user_id);
    }

    public int deleteCollect_logByFile_idAndUser_id(String file_id,String user_id){
        return collect_logDao.deleteCollect_logByFile_idAndUser_id(file_id,user_id);
    }
}
