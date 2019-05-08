package com.example.filetrade.controller;

import com.example.filetrade.entity.User;
import com.example.filetrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //add
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String post(@RequestParam(value = "uid")String uid,
                        @RequestParam(value = "name")String name,
                        @RequestParam(value = "credit" )int credit){
        User user=new User();
        user.setUid(uid);
        user.setName(name);
        user.setCredit(credit);

        int t= userService.add(user);
        if(t==1){
            return user.toString();
        }else {
            return "fail";
        }
    }

    //update
    @RequestMapping(value = "/{uid}",method = RequestMethod.PUT)
    public String update(@PathVariable("uid")String uid,
                          @RequestParam(value = "name", required = true)String name,
                          @RequestParam(value = "credit", required = true)int credit){
        User user=new User();
        user.setUid(uid);
        user.setName(name);
        user.setCredit(credit);

        int t= userService.update(user);
        if(t==1){
            return user.toString();
        }else {
            return "fail";
        }
    }

    //search
    @RequestMapping(value = "/{uid}",method = RequestMethod.GET)
    public User getUserByUid(@PathVariable("uid") String uid){
        return userService.findUserByUid(uid);
    }
}
