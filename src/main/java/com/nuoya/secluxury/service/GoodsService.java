package com.nuoya.secluxury.service;

import com.nuoya.secluxury.pojo.Brand;
import com.nuoya.secluxury.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> selectAllGoodsBy(Map<String, Object> map);

    List<Goods> selectAllGoods();

    List<Brand> selectAllBrand();
}
