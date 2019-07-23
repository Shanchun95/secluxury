package com.nuoya.secluxury.service.impl;

import com.nuoya.secluxury.mapper.GoodsBrandMapper;
import com.nuoya.secluxury.pojo.GoodsBrand;
import com.nuoya.secluxury.pojo.GoodsType;
import com.nuoya.secluxury.service.GoodsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsBrandServiceImpl implements GoodsBrandService {

    @Autowired
    GoodsBrandMapper goodsBrandMapper;
    @Override
    public List<GoodsBrand> brandGoodsList() {
        List<GoodsBrand> goodsBrandList = goodsBrandMapper.brandGoodsList();
        return goodsBrandList;
    }
}
