package com.nuoya.secluxury.mapper;


import com.nuoya.secluxury.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int login(User user);

    List<User> getUserList();

    int selectByName(User user);

    int addUser(User user);


}
