package com.nuoya.secluxury.service.impl;

import com.nuoya.secluxury.mapper.GoodsMapper;
import com.nuoya.secluxury.pojo.Brand;
import com.nuoya.secluxury.pojo.Goods;
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
    public List<Goods> selectAllGoods() {
        List<Goods> goodsList = goodsMapper.selectAllGoods();
        return goodsList;
    }

    @Override
    public List<Brand> selectAllBrand() {
        List<Brand> brandList = goodsMapper.selectAllBrand();
        return brandList;
    }
}
