package com.nuoya.secluxury.service;

import com.nuoya.secluxury.pojo.*;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> selectAllGoodsBy(Map<String, Object> map);

    List<Goods> selectAllGoods();

    List<Brand> selectAllBrand();

    List<GoodsPriceStatus> selectAllPriceStatus();

    List<GoodsPeopleType> selectAllPeopleType();

    List<GoodsNew> selectAllGoodsNew();

    Goods getGoodsById(int goodsId);
}
