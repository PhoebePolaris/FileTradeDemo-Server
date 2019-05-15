package com.example.filetrade.controller;

import com.example.filetrade.entity.Upload_log;
import com.example.filetrade.service.Upload_logService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2019/5/15.
 */
@RestController
@RequestMapping("/upload_log")
public class Upload_logController {
    @Autowired
    private Upload_logService upload_logService;

    //add
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String post(@RequestParam(value = "file_id") String file_id,
                       @RequestParam(value = "user_id")String user_id) {
        Upload_log upload_log = new Upload_log();
        upload_log.setFile_id(file_id);
        upload_log.setUser_id(user_id);
        upload_log.setLog_id(UUID.randomUUID().toString().replaceAll("-", ""));
        int t = upload_logService.add(upload_log);
        if (t == 1) {
            return upload_log.toString();
        } else {
            return "fail";
        }
    }


    //search
    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public List<Upload_log> getUpload_logByUser_id(@PathVariable("user_id") String user_id) {
        return upload_logService.findUpload_logByUser_id(user_id);
    }

    //delete
    @RequestMapping(value = "/{file_id}/{user_id}", method = RequestMethod.POST)
    public int deleteUpload_logByFile_idAndUser_id(@PathVariable(value = "file_id") String file_id,
                                                     @PathVariable(value = "user_id")String user_id) {
        return upload_logService.deleteUpload_logByFile_idAndUser_id(file_id,user_id);
    }

}
