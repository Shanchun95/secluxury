package com.nuoya.secluxury.pojo;

public class GoodsPeopleType {
    private int id;
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
