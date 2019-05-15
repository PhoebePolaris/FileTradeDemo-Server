package com.example.filetrade.service;

import com.example.filetrade.dao.Download_logDao;
import com.example.filetrade.entity.Download_log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */
@Service
public class Download_logService {
    @Autowired
    private Download_logDao download_logDao;
    //add
    public int add(Download_log download_log) {
        return download_logDao.add(download_log);
    }

    //search
    public List<Download_log> findDownload_logByUser_id(String user_id){
        return download_logDao.findDownload_logByUser_id(user_id);
    }

    public int deleteDownload_logByFile_idAndUser_id(String file_id,String user_id){
        return download_logDao.deleteDownload_logByFile_idAndUser_id(file_id,user_id);
    }
}
