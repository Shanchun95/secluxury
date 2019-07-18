package com.nuoya.secluxury.service.impl;

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
    @Override
    public int login(User user) {

        return 0;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = mapper.getUserList();
        return userList;
    }
}
