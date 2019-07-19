package com.nuoya.secluxury.controller;

import com.nuoya.secluxury.pojo.GoodsType;
import com.nuoya.secluxury.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class GoodsTypeController {

    @Autowired
    GoodsTypeService goodsTypeService;

    @RequestMapping("/typeList")
    public List<GoodsType> typeList(){
        List<GoodsType> goodsTypeList = goodsTypeService.typeList();
        return goodsTypeList;
    }

}
