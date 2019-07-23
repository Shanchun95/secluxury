package com.nuoya.secluxury.service.impl;

import com.nuoya.secluxury.mapper.GoodsMapper;
import com.nuoya.secluxury.pojo.*;
import com.nuoya.secluxury.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectAllGoodsBy(Map<String, Object> map) {
        List<Goods> goodsList = goodsMapper.selectAllGoodsBy(map);
        return goodsList;
    }

    @Override
    public List<Brand> selectAllBrand() {
        List<Brand> brandList = goodsMapper.selectAllBrand();
        return brandList;
    }

    @Override
    public List<GoodsPriceStatus> selectAllPriceStatus() {
        List<GoodsPriceStatus> goodsPriceStatusList = goodsMapper.selectAllPriceStatus();
        return goodsPriceStatusList;
    }

    @Override
    public List<GoodsPeopleType> selectAllPeopleType() {
        List<GoodsPeopleType> goodsPeopleTypeList = goodsMapper.selectAllPeopleType();
        return goodsPeopleTypeList;
    }

    @Override
    public List<GoodsNew> selectAllGoodsNew() {
        List<GoodsNew> goodsNewList = goodsMapper.selectAllGoodsNew();
        return goodsNewList;
    }

    @Override
    public Goods getGoodsById(int id) {
        Goods goods = goodsMapper.getGoodsById(id);
        return goods;
    }
}
