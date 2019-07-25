package com.nuoya.secluxury.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel("GoodsBrand商品品牌的实体类")
public class GoodsBrand {
    @ApiModelProperty("商品品牌的编号")
    private int id;
    @ApiModelProperty("商品品牌名称")
    private String brand;
    @ApiModelProperty("商品品牌关联的商品种类编号")
    private int typeId;

    private List<Goods> goodsList;
    public GoodsBrand() {
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "GoodsBrand{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", typeId=" + typeId +
                ", goodsList=" + goodsList +
                '}';
    }
}
