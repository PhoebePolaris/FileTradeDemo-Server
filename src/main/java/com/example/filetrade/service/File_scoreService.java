package com.example.filetrade.service;

import com.example.filetrade.dao.File_scoreDao;
import com.example.filetrade.entity.File_score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */
@Service
public class File_scoreService {
    @Autowired
    private File_scoreDao file_scoreDao;
    //add
    public int add(File_score file_score) {
        return file_scoreDao.add(file_score);
    }

    //update
    public int update(File_score file_score) {
        return file_scoreDao.update(file_score);
    }

    //search
    public List<File_score> findFile_scoreByFile_id(String file_id){
        return file_scoreDao.findFile_scorelByFile_id(file_id);
    }

    //search
    public File_score findFile_scoreByFile_idAndUser_id(String file_id,String user_id){
        return file_scoreDao.findFile_scorelByFile_idAndUser_id(file_id,user_id);
    }
}
