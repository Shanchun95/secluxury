package com.nuoya.secluxury.mapper;

import com.nuoya.secluxury.pojo.KeepService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KeepServiceMapper {
    List<KeepService> getAllService(Integer serviceType);
}