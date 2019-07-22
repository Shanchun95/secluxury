package com.nuoya.secluxury.service;

import com.nuoya.secluxury.pojo.User;



public interface UserService {
    int login(User user);

    int selectByName(User user);

    int addUser(User user);

    int addUserInformation(User user);

    int addUserPhoto(User user);

    int editPassword(User user);
}
