package com.example.filetrade.controller;

import com.example.filetrade.entity.User_label;
import com.example.filetrade.service.User_labelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lenovo on 2019/5/15.
 */
@RestController
@RequestMapping("/user_label")
public class User_labelController {
    @Autowired
    private User_labelService user_labelService;

    //add
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String post(@RequestBody User_label user_label
//            @RequestParam(value = "user_id") String user_id
    ) {
//        User_label user_label = new User_label();
//        user_label.setUser_id(user_id);
        int t = user_labelService.add(user_label);
        if (t == 1) {
            return user_label.toString();
        } else {
            return "fail";
        }
    }

    //update
    //更新标签
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody User_label user_label){
//            @PathVariable("user_id") String user_id,
//                          @RequestParam(value = "label", required = true) String label) {
//        User_label user_label = new User_label();
//        user_label.setUser_id(user_id);
//        user_label.setLabel(label);
        int t = user_labelService.update(user_label);
        if (t == 1) {
            return user_label.toString();
        } else {
            return "fail";
        }
    }

    //search
    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public User_label getUser_labelByUser_id(@PathVariable("user_id") String user_id) {
        return user_labelService.findUser_labelByUser_id(user_id);
    }
}