package com.nuoya.secluxury.service.impl;

import com.nuoya.secluxury.mapper.GoodsTypeMapper;
import com.nuoya.secluxury.pojo.GoodsType;
import com.nuoya.secluxury.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    GoodsTypeMapper goodsTypeMapper;
    @Override
    public List<GoodsType> typeList() {
        List<GoodsType> goodsTypeList = goodsTypeMapper.typeList();
        return goodsTypeList;
    }

    @Override
    public List<GoodsType> getTypeList() {
        List<GoodsType> typeList = goodsTypeMapper.getTypeList();
        return typeList;
    }
}
