package com.nuoya.secluxury.mapper;


import com.nuoya.secluxury.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    int login(User user);

    List<User> getUserList();

    int selectByName(User user);

    int addUser(User user);


}
