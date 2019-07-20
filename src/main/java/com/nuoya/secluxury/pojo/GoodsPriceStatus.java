package com.nuoya.secluxury.pojo;

public class GoodsPriceStatus {
    private int id;
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
