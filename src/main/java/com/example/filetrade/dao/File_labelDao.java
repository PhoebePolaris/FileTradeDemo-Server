package com.example.filetrade.dao;

import com.example.filetrade.entity.File_label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/5/15.
 */

@Repository
public class File_labelDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //add File_label
    public int add(File_label file_label) {
        return jdbcTemplate.update("INSERT INTO file_label(file_id,label_1,label_2,label_3) VALUES (?, ?, ?, ?)",
                file_label.getFile_id(),file_label.getLabel_1(),file_label.getLabel_2(),file_label.getLabel_3());

    }

    //update
    public int update(File_label file_label) {
        return jdbcTemplate.update("UPDATE file_label SET label_1 = ?,label_2= ?,label_3=?  WHERE file_id=?",
                file_label.getLabel_1(),file_label.getLabel_2(),file_label.getLabel_3(),file_label.getFile_id());
    }

    //search
    public File_label findFile_labelByFile_id(String file_id){
        List<File_label> list = jdbcTemplate.query("SELECT * FROM file_label WHERE file_id = ?", new Object[]{file_id}, new BeanPropertyRowMapper(File_label.class));
        if(list!=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}
