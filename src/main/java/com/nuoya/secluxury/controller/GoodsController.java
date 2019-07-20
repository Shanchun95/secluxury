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

    @RequestMapping("/serchgoods")
    @ApiOperation("该方法用于查询所有的商品，包括模糊查询，条件查询")
    public List<Goods> selectAllGoodsBy(HttpServletResponse response, HttpServletRequest request, @ApiParam(value = "关键词搜索，传入String类型",defaultValue = "dfsdfs") String keyWords, @ApiParam("按照种类搜索,传Integer类型的值")Integer typeId, @ApiParam("按品牌搜索，传品牌id，Integer类型") Integer brandId, @ApiParam("按价格分段查询，传入状态值(Integer类型1、2、3、4、5)：价格范围：1:x<1000、2:1000<x<5000、3:5000<x<1W、4:1W<x<10W、5:10W<x") Integer priceStatus, @ApiParam("适用人群（Integer类型0、1、2）0：通用、1：男士、2：女士") Integer peopleType, @ApiParam("成色：95新则传int的95，9新传90，全新传值100") Integer goodsNew, @ApiParam("发布时间排序，传一个字符串createTime即可(前台应控制三个排序同时只能选一个！否则我后台的算法报错)") String createTime, @ApiParam("价格升序，传一个字符串priceAsc即可(前台应控制三个排序同时只能选一个！否则我后台的算法报错)") String priceAsc, @ApiParam("价格降序，传一个字符串priceDesc即可(前台应控制三个排序同时只能选一个！否则我后台的算法报错)") String priceDesc) {
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

    @RequestMapping("/getgoodsbyid")
    @ApiOperation("当用户点击展示出来的所有商品中的其中一个时，给我传一个商品id，我给你展示这个商品的所有属性")
    public Goods getGoodsById(@ApiParam("传参为商品的goodsId") int goodsId) {
        Goods goods = goodsService.getGoodsById(goodsId);
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
