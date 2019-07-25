package com.nuoya.secluxury.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ShoppingCar购物车实体类")
public class ShoppingCar {
    private int id;
    @ApiModelProperty("用户的email")
    private String email;
    @ApiModelProperty("加入购物车的商品的id")
    private int shoppingGoodsId;
    @ApiModelProperty("购物车中该商品的数量")
    private int num;
    @ApiModelProperty("购物车中指定商品的总价")
    private float totalPrice;
    @ApiModelProperty("购物车中所有商品的总价")
    private float shoppingCarPrice;
    @ApiModelProperty("一对多查询，由商品的id查询到该商品的所有信息，用以展示购物车中商品的详情")
    private Goods goods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getShoppingGoodsId() {
        return shoppingGoodsId;
    }

    public void setShoppingGoodsId(int shoppingGoodsId) {
        this.shoppingGoodsId = shoppingGoodsId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getShoppingCarPrice() {
        return shoppingCarPrice;
    }

    public void setShoppingCarPrice(float shoppingCarPrice) {
        this.shoppingCarPrice = shoppingCarPrice;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", shoppingGoodsId=" + shoppingGoodsId +
                ", num=" + num +
                ", totalPrice=" + totalPrice +
                ", shoppingCarPrice=" + shoppingCarPrice +
                ", goods=" + goods +
                '}';
    }
}
