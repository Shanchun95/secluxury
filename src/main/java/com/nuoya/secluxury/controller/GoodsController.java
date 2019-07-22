package com.nuoya.secluxury.controller;


import com.nuoya.secluxury.pojo.*;
import com.nuoya.secluxury.service.GoodsService;
import com.nuoya.secluxury.utils.JedisClient;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
    @RestController
    @RequestMapping(value = "goods",method = RequestMethod.POST)
    public class GoodsController {

        @Autowired
        GoodsService goodsService;

        @Autowired
        private JedisClient jedisClient;

        @RequestMapping(value = "searchgoods")
        @ApiOperation("该方法用于查询所有的商品，包括模糊查询，条件查询")
        public List<Goods> selectAllGoodsBy(HttpServletResponse response, HttpServletRequest request, String keyWords, Integer typeId, Integer brandId, Integer priceStatus, Integer peopleType, Integer goodsNew, String createTime, String priceAsc, String priceDesc) {
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

    @RequestMapping(value = "getgoodsbyid")
    @ApiOperation("当用户点击展示出来的所有商品中的其中一个时，给我传一个商品id，我给你展示这个商品的所有属性")
    public Goods getGoodsById(int id) {
        Goods goods = goodsService.getGoodsById(id);
        System.out.println("通过id查到的商品信息："+goods);
        return goods;
    }
    @RequestMapping("/test")
    @ApiOperation("后端用来测试的方法，前端不必使用")
    public List<Goods> selectAllGoods() {
        List<Goods> goodsList = goodsService.selectAllGoods();
        System.out.println(goodsList);
        return goodsList;
    }

    @RequestMapping("/brandlist")
    @ApiOperation("展示所有的品牌，供用户选择")
    public List<Brand> selectAllBrand() {
        List<Brand> brandList = goodsService.selectAllBrand();
        System.out.println(brandList);
        return brandList;
    }

    @RequestMapping("/goodspricestatuslist")
    @ApiOperation("展示商品的所有的价格范围，供用户选择")
    public List<GoodsPriceStatus> selectAllPriceStatus() {
        List<GoodsPriceStatus> goodsPriceStatusList = goodsService.selectAllPriceStatus();
        System.out.println(goodsPriceStatusList);
        return goodsPriceStatusList;
    }

    @RequestMapping("/peopletypelist")
    @ApiOperation("展示所有适用人群，供用户选择")
    public List<GoodsPeopleType> selectAllPeopleType() {
        List<GoodsPeopleType> goodsPeopleTypeList = goodsService.selectAllPeopleType();
        System.out.println(goodsPeopleTypeList);
        return goodsPeopleTypeList;
    }

    @RequestMapping("/goodsnewlist")
    @ApiOperation("展示商品的成色信息，供用户选择")
    public List<GoodsNew> selectAllGoodsNew() {
        List<GoodsNew> goodsNewList = goodsService.selectAllGoodsNew();
        System.out.println(goodsNewList);
        return goodsNewList;

    }


}
