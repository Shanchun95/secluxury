package com.nuoya.secluxury.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("GoodsPeopleType适用人群实体类")
public class GoodsPeopleType {
    private int id;
    @ApiModelProperty("使用人群类型")
    private String peopleType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(String peopleType) {
        this.peopleType = peopleType;
    }

    @Override
    public String toString() {
        return "GoodsPeopleType{" +
                "id=" + id +
                ", peopleType='" + peopleType + '\'' +
                '}';
    }
}
