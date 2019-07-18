package com.nuoya.secluxury.controller;


import com.nuoya.secluxury.pojo.Goods;
import com.nuoya.secluxury.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/serchGoods")
    @ResponseBody
    public List<Goods> selectAllGoodsBy() {
        Map<String,String> map = new HashMap<String,String>();
        List<Goods> goodsList = goodsService.selectAllGoodsBy(map);
        return goodsList;

    }
}
