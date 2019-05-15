package com.example.filetrade.controller;

import com.example.filetrade.entity.Buy_log;
import com.example.filetrade.service.Buy_logService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2019/5/15.
 */
@RestController
@RequestMapping("/buy_log")
public class Buy_logController {
    @Autowired
    private Buy_logService buy_logService;

    //add
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String post(@RequestBody Buy_log buy_log) {
        int t = buy_logService.add(buy_log);
        if (t == 1) {
            return buy_log.toString();
        } else {
            return "fail";
        }
    }


    //search
    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public List<Buy_log> getBuy_logByUser_id(@PathVariable("user_id") String user_id) {
        return buy_logService.findBuy_logByUser_id(user_id);
    }

    //delete
    @RequestMapping(value = "/{file_id}/{user_id}", method = RequestMethod.POST)
    public int deleteBuy_logByFile_idAndUser_id(@PathVariable(value = "file_id") String file_id,
                                                 @PathVariable(value = "user_id")String user_id) {
        return buy_logService.deleteBuy_logByFile_idAndUser_id(file_id,user_id);
    }

}
