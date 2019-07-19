package com.nuoya.secluxury.mapper;

import com.nuoya.secluxury.pojo.Brand;
import com.nuoya.secluxury.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface GoodsMapper {
    List<Goods> selectAllGoodsBy(Map<String, Object> map);

    List<Goods> selectAllGoods();

    List<Brand> selectAllBrand();
}
