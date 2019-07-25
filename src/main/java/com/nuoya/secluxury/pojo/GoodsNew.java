package com.nuoya.secluxury.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("GoodsNew商品成色信息类（即新旧程度）")
public class GoodsNew {
    private int id;
    @ApiModelProperty("商品的成色")
    private String goodsNew;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsNew() {
        return goodsNew;
    }

    public void setGoodsNew(String goodsNew) {
        this.goodsNew = goodsNew;
    }

    @Override
    public String toString() {
        return "GoodsNew{" +
                "id=" + id +
                ", goodsNew='" + goodsNew + '\'' +
                '}';
    }
}
