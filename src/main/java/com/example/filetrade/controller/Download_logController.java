package com.example.filetrade.controller;

import com.example.filetrade.entity.Download_log;
import com.example.filetrade.service.Download_logService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2019/5/15.
 */

@RestController
@RequestMapping("/download_log")
public class Download_logController {
    @Autowired
    private Download_logService download_logService;

    //add
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String post(@RequestBody Download_log download_log) {
        int t = download_logService.add(download_log);
        if (t == 1) {
            return download_log.toString();
        } else {
            return "fail";
        }
    }


    //search
    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public List<Download_log> getDownload_logByUser_id(@PathVariable("user_id") String user_id) {
        return download_logService.findDownload_logByUser_id(user_id);
    }

    //delete
    @RequestMapping(value = "/{file_id}/{user_id}", method = RequestMethod.POST)
    public int deleteDownload_logByFile_idAndUser_id(@PathVariable(value = "file_id") String file_id,
                                                    @PathVariable(value = "user_id")String user_id) {
        return download_logService.deleteDownload_logByFile_idAndUser_id(file_id,user_id);
    }

}