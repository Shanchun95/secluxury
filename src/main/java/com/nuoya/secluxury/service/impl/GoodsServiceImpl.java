package com.nuoya.secluxury.service.impl;

import com.nuoya.secluxury.mapper.GoodsMapper;
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
    public List<Goods> selectAllGoodsBy(Map<String, String> map) {
     //   List<Goods> goodsList = goodsMapper.selectAllGoodsBy(map);
      return null;
    }
}
