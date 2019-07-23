package com.nuoya.secluxury.pojo;

public class GoodsNew {
    private int id;
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
