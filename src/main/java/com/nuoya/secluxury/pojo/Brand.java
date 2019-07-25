package com.nuoya.secluxury.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Brand商品品牌的实体类")
public class Brand {
    @ApiModelProperty("品牌的id")
    private int id;
    @ApiModelProperty("品牌名")
    private String brand;
    @ApiModelProperty("对应的类型id")
    private int typeId;

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
        return "Brand{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}
