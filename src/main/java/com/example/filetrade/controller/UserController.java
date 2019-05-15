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
    public String post(@RequestBody User user){
        //前端构造uuid
//        String user_id=UUID.randomUUID().toString().replaceAll("-", "");
//        user.setUser_id(user_id);

//        int credit=0;
//        user.setCredit(credit);

        User_label user_label = new User_label();
        user_label.setUser_id(user.getUser_id());

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
                          @RequestParam(value = "credit", required = true)int credit){
        User user=userService.findUserByUser_id(user_id);
        user.setCredit(user.getCredit()+credit);

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

    //login
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody User user){
        return userService.login(user);
    }

    //修改
    @RequestMapping(value = "/updateOther",method = RequestMethod.PUT)
    public int updateOther(@RequestBody User user){
        return userService.updateOther(user);
    }

}
