package com.nuoya.secluxury.mapper;

import com.nuoya.secluxury.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsMapper {
    List<Goods> selectAllGoodsBy(Map<String, String> map);
}
