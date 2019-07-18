package com.nuoya.secluxury.service;

import com.nuoya.secluxury.pojo.User;

import java.util.List;

public interface UserService {
    int login(User user);

    int selectByName(User user);

    int addUser(User user);
}
