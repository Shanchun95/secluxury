package com.nuoya.secluxury.mapper;

import com.nuoya.secluxury.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginMapper {

    int addUserLogin(User user);
}
