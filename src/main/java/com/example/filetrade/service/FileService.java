package com.example.filetrade.service;

import com.example.filetrade.dao.FileDao;
import com.example.filetrade.entity.FileBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    @Autowired
    private FileDao fileDao;

    public int upload(FileBean fileBean) {
        return fileDao.upload(fileBean);
    }
}
