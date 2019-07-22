package com.nuoya.secluxury.controller;

import com.nuoya.secluxury.pojo.User;
import com.nuoya.secluxury.service.UserService;
import com.nuoya.secluxury.utils.JedisClient;
import com.nuoya.secluxury.utils.MailUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private JedisClient jedisClient;

    @RequestMapping("login")
    @ApiOperation("用户登录功能，需要传递用户名称（email）初始值为admin、密码（password）初始值为admin.如果用户名密码正确将用户名保存到cookie中，返回数字“ 1 ”、否则返回数字“ 0 ”")
    public int login(String email, String password,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println(email);
        User user = new User();
        user.setUserName(email);
        user.setPassword(password);
        int i = userService.login(user);
        if (i == 1){
            Cookie userCookie = new Cookie("NAME",user.getUserName());
            userCookie.setMaxAge(30*24*60*60);   //存活期为一个月 30*24*60*60
            userCookie.setPath("/");
            response.addCookie(userCookie);
        }
        return i;
    }
    @RequestMapping("validateUserName")
    @ApiOperation("用户注册功能，用户注册时需要传递用户邮箱到后台，对邮箱进行校验，如果用户邮箱已存在无法再次注册，已存在返回数字“ 1 ” 、不存在返回数字“ 0 ”")
    public int validateName(String email){
        User user = new User();
        user.setUserName(email);
        int result = userService.selectByName(user);
        return result;
    }
    @RequestMapping("sendEmail")
    @ApiOperation("用户注册功能：用户注册时，当用户填写完邮箱（email）后点击获取验证码，后台会向用户的邮箱发送一个验证码,并将该验证码写入到session域中name为（yzm）发送成功返回数字“ 1 ”")
    public int sendEmail(String email){
            System.out.println(email);
            String letterStr = "a,b,c,d,e,f,g,h,i,j,k,m,n,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,U,V,W,X,Y,Z";
            String[] strs = letterStr.split(",");
            Random random = new Random();
            String str = "";
            for (int i = 0; i<4;i++){
                str += strs[random.nextInt(strs.length+1)];
            }
            jedisClient.set("yzm", str);
            MailUtils.sendMail(email,"验证码:"+str,"邮箱验证码");
            return 1;
        }
    @RequestMapping("validateYzm")
    @ApiOperation("用户注册功能，用户注册页面向后台传递一个“验证码”后台会对其进行校验，如果正确返回数字“ 1 ” 否则返回“ 0 ”")
    public int validateYzm(@ApiParam("用户收到的验证码") String u_yzm) {
        String h_yzm = jedisClient.get("yzm");
        if (u_yzm.equals(h_yzm)){
            return 1;
        }
        return 0;
    }


    @RequestMapping("addUser")
    @ApiOperation("用户注册功能，当用户注册填写好注册信息后点击注向后台传递用户邮箱（email）和登录密码（password），注册成功返回数字“ 1 ” 、失败返回数字“ 0 ”")
    public int addUser(String email,String password){
        User user = new User();
        user.setUserName(email);
        user.setPassword(password);
        int result = userService.addUser(user);
        return result;
    }
}