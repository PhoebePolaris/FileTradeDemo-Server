package com.example.filetrade.dao;

import com.example.filetrade.entity.FileBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FileDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //upload
    public int upload(FileBean file) {
        return jdbcTemplate.update("INSERT INTO file(file_id, size, file_title,creation_time,file_type,credit,creator_id,score) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                file.getFile_id(),file.getSize(),file.getFile_title(),file.getCreation_time(),file.getFile_type(),file.getCredit(),file.getCreator_id(),file.getScore());

    }
}
