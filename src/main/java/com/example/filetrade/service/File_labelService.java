package com.example.filetrade.service;

import com.example.filetrade.dao.File_labelDao;
import com.example.filetrade.entity.File_label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2019/5/15.
 */
@Service
public class File_labelService {
    @Autowired
    private File_labelDao file_labelDao;

    //add
    public int add(File_label file_label) {
        return file_labelDao.add(file_label);
    }

    //update
    public int update(File_label file_label) {
        return file_labelDao.update(file_label);
    }

    //search
    public File_label findFile_labelByFile_id(String file_id){
        return file_labelDao.findFile_labelByFile_id(file_id);
    }
}
