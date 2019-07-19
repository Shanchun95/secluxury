package com.nuoya.secluxury.controller;


import com.nuoya.secluxury.pojo.Goods;
import com.nuoya.secluxury.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/serchGoods")
    @ApiOperation("该方法用于查询所有的商品，包括模糊查询，条件查询")
    public List<Goods> selectAllGoodsBy(HttpServletResponse response, HttpServletRequest request, @ApiParam(value = "关键词搜索，传入String类型",defaultValue = "dfsdfs") String keyWords, @ApiParam("按照种类搜索,传Integer类型的值")Integer typeId, @ApiParam("按品牌搜索，传品牌id，Integer类型") Integer brandId, @ApiParam("按价格分段查询，传入状态值(Integer类型1、2、3、4、5)：价格范围：1:x<1000、2:1000<x<5000、3:5000<x<1W、4:1W<x<10W、5:10W<x") Integer priceStatus, @ApiParam("适用人群（Integer类型0、1、2）0：通用、1：男士、2：女士") Integer peopleType, @ApiParam("成色：95新则传int的95，9新传90，全新传值100") Integer goodsNew, @ApiParam("发布时间排序") String createTime, @ApiParam("价格升序") String priceAsc, @ApiParam("价格降序") String priceDesc) {
        response.setHeader("Access-Control-Allow-Origin", "*");


        Map<String,Object> map = new HashMap<String,Object>();
        map.put("keyWords",keyWords);
        map.put("typeId",typeId);
        map.put("brandId",brandId);
        map.put("priceStatus",priceStatus);
        map.put("peopleType",peopleType);
        map.put("goodsNew",goodsNew);
        map.put("createTime",createTime);
        map.put("priceAsc",priceAsc);
        map.put("priceDesc",priceDesc);
        System.out.println(map);
        List<Goods> goodsList = goodsService.selectAllGoodsBy(map);
        System.out.println(goodsList);

        return goodsList;

    }
    @RequestMapping("/aaa")
    public List<Goods> selectAllGoods() {
        List<Goods> goodsList = goodsService.selectAllGoods();
        return goodsList;
    }
}
