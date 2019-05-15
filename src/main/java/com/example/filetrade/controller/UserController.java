package com.example.filetrade.controller;

import com.example.filetrade.entity.User;
import com.example.filetrade.entity.User_label;
import com.example.filetrade.service.UserService;
import com.example.filetrade.service.User_labelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private User_labelService user_labelService;

    //add
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String post(@RequestParam(value = "user_name")String user_name,
                        @RequestParam(value = "phone_num")String phone_num,
                        @RequestParam(value = "password")String password){
        User user=new User();
        String user_id=UUID.randomUUID().toString().replaceAll("-", "");
        user.setUser_id(user_id);
        user.setPhone_num(phone_num);
        user.setPassword(password);
        user.setUser_name(user_name);
        int credit=0;
        user.setCredit(credit);

        User_label user_label = new User_label();
        user_label.setUser_id(user_id);

        int s=user_labelService.add(user_label);
        int t= userService.add(user);
        if(t==1&&s==1){
            return user.toString()+user_label.toString();
        }else {
            return "fail";
        }
    }

    //update
    //更新积分
    @RequestMapping(value = "/{user_id}",method = RequestMethod.PUT)
    public String update(@PathVariable("user_id")String user_id,
                          @RequestParam(value = "user_name", required = true)String user_name,
                          @RequestParam(value = "credit", required = true)int credit){
        User user=new User();
        user.setUser_id(user_id);
        user.setUser_name(user_name);
        user.setCredit(credit);

        int t= userService.update(user);
        if(t==1){
            return user.toString();
        }else {
            return "fail";
        }
    }

    //search
    @RequestMapping(value = "/{user_id}",method = RequestMethod.GET)
    public User getUserByUser_id(@PathVariable("user_id") String user_id){
        return userService.findUserByUser_id(user_id);
    }
}
