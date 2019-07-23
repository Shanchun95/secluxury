package com.nuoya.secluxury.mapper;

import com.nuoya.secluxury.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GoodsTypeMapper {

    List<GoodsType> typeList();

    List<GoodsType> getTypeList();
}
