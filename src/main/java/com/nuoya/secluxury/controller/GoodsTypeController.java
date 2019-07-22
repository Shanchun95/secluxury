package com.nuoya.secluxury.controller;

import com.nuoya.secluxury.pojo.GoodsBrand;
import com.nuoya.secluxury.pojo.GoodsType;
import com.nuoya.secluxury.service.GoodsBrandService;
import com.nuoya.secluxury.service.GoodsTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "type",method = RequestMethod.GET)
public class GoodsTypeController {

    @Autowired
    GoodsTypeService goodsTypeService;
    @Autowired
    GoodsBrandService goodsBrandService;

    /*@RequestMapping("/typeList")
    @ApiOperation("商品类别查询接口，调用该接口会返回商品种类的json数据其中包括 商品的种类、商品的品牌、具体的商品信息")
    public List<GoodsType> typeList(){
        List<GoodsType> goodsTypeList = goodsTypeService.typeList();
        return goodsTypeList;
    }*/
    @RequestMapping("/brandList")
    @ApiOperation("商品品牌查询接口，调用该接口会返回商品种类的json数据其中包括 商品的种类、商品的品牌")
    public List<GoodsType> getTypeList(){
        List<GoodsType> goodsTypeList = goodsTypeService.getTypeList();
        return goodsTypeList;
    }
    @RequestMapping("/brandGoodsList")
    @ApiOperation("商品品牌查询接口，调用该接口会返回商品种类的json数据其中包括 商品的品牌、具体的商品信息")
    public List<GoodsBrand> brandGoodsList(){
        List<GoodsBrand> goodsBrands = goodsBrandService.brandGoodsList();
        return goodsBrands;
    }
}
