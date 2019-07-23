package com.nuoya.secluxury.mapper;

import com.nuoya.secluxury.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface GoodsMapper {
    List<Goods> selectAllGoodsBy(Map<String, Object> map);

//    List<Goods> selectAllGoods();

    List<Brand> selectAllBrand();

    List<GoodsPriceStatus> selectAllPriceStatus();

    List<GoodsPeopleType> selectAllPeopleType();

    List<GoodsNew> selectAllGoodsNew();

    Goods getGoodsById(int id);
}
