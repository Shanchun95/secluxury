package com.nuoya.secluxury.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("GoodsPriceStatus商品价格范围")
public class GoodsPriceStatus {
    private int id;
    @ApiModelProperty("商品的价格范围值")
    private String priceStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPriceStatus() {
        return priceStatus;
    }

    public void setPriceStatus(String priceStatus) {
        this.priceStatus = priceStatus;
    }

    @Override
    public String toString() {
        return "GoodsPriceStatus{" +
                "id=" + id +
                ", priceStatus='" + priceStatus + '\'' +
                '}';
    }
}
