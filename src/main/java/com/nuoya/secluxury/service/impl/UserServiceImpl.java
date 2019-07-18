package com.nuoya.secluxury.service.impl;

import com.nuoya.secluxury.mapper.UserLoginMapper;
import com.nuoya.secluxury.mapper.UserMapper;
import com.nuoya.secluxury.pojo.User;
import com.nuoya.secluxury.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;
    @Autowired
    UserLoginMapper ligonMapper;
    @Override
    public int login(User user) {
        int i = mapper.login(user);
        return i>0? 1:0;
    }


    @Override
    public int selectByName(User user) {
        int result = mapper.selectByName(user);
        return result >0? 1:0;
    }
    //由于用户信息和用户密码是分离的所以要同时向用户信息表和用户密码表中插入用户信息
    @Override
    public int addUser(User user) {
        int i = mapper.addUser(user);
        int i2 = ligonMapper.addUserLogin(user);
        return i>0&&i2>0? 1:0;
    }

}
