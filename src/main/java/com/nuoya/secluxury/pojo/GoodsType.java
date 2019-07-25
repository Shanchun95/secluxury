package com.nuoya.secluxury.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.List;

@ApiModel("GoodsType商品类别实体类")
public class GoodsType {
    @ApiModelProperty("商品种类编号（主键）")
    private int typeId;
    @ApiModelProperty("商品种类名称")
    private String type;

    @ApiModelProperty("商品种类对应的商品的信息")
    private List<Goods> goodsList;

    @ApiModelProperty("商品种类对应的商品品牌信息")
    private  List<GoodsBrand> goodsBrandList;
    public GoodsType() {
    }

    public List<GoodsBrand> getGoodsBrandList() {
        return goodsBrandList;
    }

    public void setGoodsBrandList(List<GoodsBrand> goodsBrandList) {
        this.goodsBrandList = goodsBrandList;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "typeId=" + typeId +
                ", type='" + type + '\'' +
                ", goodsList=" + goodsList +
                ", goodsBrandList=" + goodsBrandList +
                '}';
    }
}
