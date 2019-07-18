package com.nuoya.secluxury.controller;

import com.nuoya.secluxury.pojo.User;
import com.nuoya.secluxury.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public String login(User user){
        int i = userService.login(user);
        return null;
    }
    @RequestMapping("getUserList")
    @ResponseBody
    public List<User> getUserList(){
        List<User> userList = userService.getUserList();
        return null;
    }

}