package com.example.filetrade.controller;

import com.example.filetrade.entity.Collect_log;
import com.example.filetrade.service.Collect_logService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2019/5/15.
 */
@RestController
@RequestMapping("/collect_log")
public class Collect_logController {
    @Autowired
    private Collect_logService collect_logService;

    //add
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String post(@RequestBody Collect_log collect_log){
        int t = collect_logService.add(collect_log);
        if (t == 1) {
            return collect_log.toString();
        } else {
            return "fail";
        }
    }


    //search
    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public List<Collect_log> getCollect_logByUser_id(@PathVariable("user_id") String user_id) {
        return collect_logService.findCollect_logByUser_id(user_id);
    }

    //delete
    @RequestMapping(value = "/{file_id}/{user_id}", method = RequestMethod.POST)
    public int deleteCollect_logByFile_idAndUser_id(@PathVariable(value = "file_id") String file_id,
                                                @PathVariable(value = "user_id")String user_id) {
        return collect_logService.deleteCollect_logByFile_idAndUser_id(file_id,user_id);
    }

}
