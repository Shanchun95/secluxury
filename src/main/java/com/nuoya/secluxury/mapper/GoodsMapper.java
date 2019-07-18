package com.nuoya.secluxury.mapper;

import com.nuoya.secluxury.pojo.Goods;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Component
public interface GoodsMapper {
    List<Goods> selectAllGoodsBy(Map<String, String> map);
}
