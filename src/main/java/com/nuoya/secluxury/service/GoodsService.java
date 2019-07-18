package com.nuoya.secluxury.service;

import com.nuoya.secluxury.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> selectAllGoodsBy(Map<String, String> map);
}
