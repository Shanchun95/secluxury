package com.nuoya.secluxury.controller;

import com.nuoya.secluxury.pojo.User;
import com.nuoya.secluxury.service.UserService;
import com.nuoya.secluxury.utils.JedisClient;
import com.nuoya.secluxury.utils.MailUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping(value = "user",method = RequestMethod.POST)
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private JedisClient jedisClient;

    @ApiOperation("用户登录功能，需要传递用户邮箱（email）初始值为admin、密码（password）初始值为admin.如果用户名密码正确将用户名保存到cookie中，返回数字“ 1 ”、否则返回数字“ 0 ”")
    @RequestMapping(value = "login")
    public int login(String email,String password,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println(email);
        User user = new User();
        user.setEmail(email);
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
    @RequestMapping("validateEmail")
    @ApiOperation("用户注册功能，用户注册时需要传递用户邮箱到后台，对邮箱进行校验，如果用户邮箱已存在无法再次注册，已存在返回数字“ 1 ” 、不存在返回数字“ 0 ”")
    public int validateEmail(String email){
        User user = new User();
        user.setEmail(email);
        int result = userService.selectByName(user);
        return result;
    }
    @RequestMapping("sendEmail")
    @ApiOperation("用户注册功能接口：调用该方法需要传递一个邮箱号，后台会向该邮箱发送一个验证码，发送成功返回数字 “ 1 ”、失败返回“ 0 ”")
    public int sendEmail(String email,HttpServletRequest request){
            System.out.println(email);
            String letterStr = "a,b,c,d,e,f,g,h,i,j,k,m,n,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,U,V,W,X,Y,Z";
            String[] strs = letterStr.split(",");
            Random random = new Random();
            String str = "";
            for (int i = 0; i<4;i++){
                str += strs[random.nextInt(strs.length+1)];
            }
            request.getSession().setAttribute("yzm", str);
            MailUtils.sendMail(email,"验证码:"+str,"邮箱验证码");
            return 1;
        }
    @RequestMapping("validateYzm")
    @ApiOperation("用户注册功能，用户注册页面向后台传递一个“验证码”后台会对其进行校验，如果正确返回数字“ 1 ” 否则返回“ 0 ”")
    public int validateYzm(String u_yzm,HttpServletRequest request) {
        String h_yzm = (String)request.getSession().getAttribute("yzm");
        if (u_yzm.equals(h_yzm)){
            return 1;
        }
        return 0;
    }
    @RequestMapping("editPassword")
    @ApiOperation("修改密码功能，需要向后台传输：用户邮箱号、新的密码,修改成功返回数字“ 1 ” 、失败返回数字“ 0 ”")
    public int editPassword(String password,String email) {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        int i = userService.editPassword(user);
        return i;
    }
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ApiOperation("用户注册功能，当用户注册填写好注册信息后点击注向后台传递用户邮箱（email）和登录密码（password），注册成功返回数字“ 1 ” 、失败返回数字“ 0 ”")
    public int addUser(String email,String password){
        System.out.println(email);
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        int result = userService.addUser(user);
        return result;
    }

    @RequestMapping("/addUserInformation")
    @ApiOperation("用户功能接口：用户修改个人信息")
    public int addUserInformation(@ApiParam("用户昵称")String userName,@ApiParam("用户性别，数字“ 1 ”代表男 、“ 0 ”代表女") int sex,String email,@ApiParam("用户二维码") String codeUrl){
        User user = new User();
        user.setUserName(userName);
        user.setPassword(userName);
        user.setSex(sex);
        user.setCodeUrl(codeUrl);
        int result = userService.addUserInformation(user);
        return result;
    }
    @RequestMapping("/addUserPhoto")
    @ApiOperation("用户功能接口：用户上传头像")
    public String addUserPhoto(@ApiParam("用户头像文件路径")MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        User user = new User();
        //定义文件名
        String fileName = "";
        //1.获取原始文件名
        System.out.println(uploadFile);
        String uploadFileName = uploadFile.getOriginalFilename();
        //2.截取文件扩展名
        String	extendName	= uploadFileName.substring(uploadFileName.lastIndexOf(".")+1, uploadFileName.length());
        //3.把文件加上随机数，防止文件重复
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        /*//4.判断是否输入了文件名
        if(!StringUtils.isEmpty(picname)) {
            fileName = uuid+"_"+picname+"."+extendName;
        }else {*/
            fileName = uuid+"_"+uploadFileName;
//        }
        System.out.println(fileName);
        //2.获取文件路径
        ServletContext context = request.getServletContext();
        String basePath = context.getRealPath("D:/images");
        System.out.println(basePath);
        //3.解决同一文件夹中文件过多问题
        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //4.判断路径是否存在
        File file = new File(basePath+"/"+datePath);
        if(!file.exists()) { file.mkdirs();
        }
        System.out.println(file);
        //5.使用 MulitpartFile 接口中方法，把上传的文件写到指定位置
        uploadFile.transferTo(new File(file,fileName));
        user.setImageUrl(datePath+"/"+fileName);
        int result = userService.addUserPhoto(user);
        return "success";
    }


}