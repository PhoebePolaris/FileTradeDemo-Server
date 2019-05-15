package com.example.filetrade.service;

import com.example.filetrade.dao.Upload_logDao;
import com.example.filetrade.entity.Upload_log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */
@Service
public class Upload_logService {
    @Autowired
    private Upload_logDao upload_logDao;
    //add
    public int add(Upload_log upload_log) {
        return upload_logDao.add(upload_log);
    }

    //search
    public List<Upload_log> findUpload_logByUser_id(String user_id){
        return upload_logDao.findUpload_logByUser_id(user_id);
    }

    public int deleteUpload_logByFile_idAndUser_id(String file_id,String user_id){
        return upload_logDao.deleteUpload_logByFile_idAndUser_id(file_id,user_id);
    }
}
