package com.nuoya.secluxury.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@ApiModel("Goods是商品的实体类，需要取参数，则调用对应属性即可")
public class Goods {
    @ApiModelProperty("商品id")
    private int goodsId;
    @ApiModelProperty("商品名")
    private String goodsName;
    @ApiModelProperty(value = "商品尺寸",example = "10*8*5/或者1米长等等")
    private String goodsSize;
    @ApiModelProperty("商品图片链接")
    private String imageUrl;

    @ApiModelProperty("品牌的id值，后台有表，前端通过brandId展示brand，用户点击brand时，传给后台的时brandId")
    private int brandId;
    @ApiModelProperty("品牌名")
    private String brand;

    @ApiModelProperty("商品详情")
    private String goodsDetail;
    @ApiModelProperty("商品种类，类似品牌，用id展示真正的名称，用户点击也是传id")
    private int typeId;
    @ApiModelProperty("商品种类")
    private String type;
    @ApiModelProperty(value = "商品成色，9成新为90，全新为100，95新为95",example = "95")
    private int goodsNew;
    @ApiModelProperty(value = "适用人群，0：全部/1：男士/2：女士",example = "0")
    private int peopleType;
    @ApiModelProperty(value = "商品邮费",example = "12")
    private int postPrice;

    @ApiModelProperty(value = "发货时间的id，这一项时一个下拉框，值固定，通过id能得到对应的名字deliveryTime",example = "2")
    private int deliveryTimeId;
    @ApiModelProperty("发货时间选择")
    private String deliveryTime;

    @ApiModelProperty("发货人名")
    private String publishUser;
    @ApiModelProperty("收货人姓名，同时通过这个姓名能得到收货人的所有信息，包括地址，电话等")
    private String receiveUser;
    @ApiModelProperty(value = "价格分布状态，为状态值，对应下拉框固定的值！价格范围：1:x<1000/2:1000<x<5000/3:5000<x<1W/4:1W<x<10W/5:10W<x",example = "2")
    private int priceStatus;
    @ApiModelProperty(value = "订单状态：0发布状态，1下单状态，2已付款未发货，3已发货，4未接货，5已接货",example = "0")
    private int orderStatus;
    @ApiModelProperty(value = "鉴定状态：0未鉴定，1鉴定中，2鉴定已通过，3鉴定未通过",example = "2")
    private int identifyStatus;
    @ApiModelProperty("商品价格")
    private float goodsPrice;
    @ApiModelProperty("平台价格")
    private float platformPrice;
    @ApiModelProperty("市场价格")
    private float marketPrice;
    @ApiModelProperty("本条商品信息创建时间")
    private String createTime;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
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

    public int getGoodsNew() {
        return goodsNew;
    }

    public void setGoodsNew(int goodsNew) {
        this.goodsNew = goodsNew;
    }

    public int getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(int peopleType) {
        this.peopleType = peopleType;
    }

    public int getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(int postPrice) {
        this.postPrice = postPrice;
    }

    public int getDeliveryTimeId() {
        return deliveryTimeId;
    }

    public void setDeliveryTimeId(int deliveryTimeId) {
        this.deliveryTimeId = deliveryTimeId;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }

    public String getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(String receiveUser) {
        this.receiveUser = receiveUser;
    }

    public int getPriceStatus() {
        return priceStatus;
    }

    public void setPriceStatus(int priceStatus) {
        this.priceStatus = priceStatus;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getIdentifyStatus() {
        return identifyStatus;
    }

    public void setIdentifyStatus(int identifyStatus) {
        this.identifyStatus = identifyStatus;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public float getPlatformPrice() {
        return platformPrice;
    }

    public void setPlatformPrice(float platformPrice) {
        this.platformPrice = platformPrice;
    }

    public float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(float marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSize='" + goodsSize + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", brandId=" + brandId +
                ", brand='" + brand + '\'' +
                ", goodsDetail='" + goodsDetail + '\'' +
                ", typeId=" + typeId +
                ", type='" + type + '\'' +
                ", goodsNew=" + goodsNew +
                ", peopleType=" + peopleType +
                ", postPrice=" + postPrice +
                ", deliveryTimeId=" + deliveryTimeId +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", publishUser='" + publishUser + '\'' +
                ", receiveUser='" + receiveUser + '\'' +
                ", priceStatus=" + priceStatus +
                ", orderStatus=" + orderStatus +
                ", identifyStatus=" + identifyStatus +
                ", goodsPrice=" + goodsPrice +
                ", platformPrice=" + platformPrice +
                ", marketPrice=" + marketPrice +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
