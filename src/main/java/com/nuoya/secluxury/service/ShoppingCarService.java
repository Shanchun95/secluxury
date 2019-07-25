package com.nuoya.secluxury.service;

import com.nuoya.secluxury.pojo.ShoppingCar;

import java.util.List;

public interface ShoppingCarService {
    List<ShoppingCar> getShoppingCar(String email);

    int selectShoppingCountById(ShoppingCar shoppingCar);

    void addShopping(ShoppingCar shoppingCar);

    void updateShoppingNum(ShoppingCar shoppingCar);

    int selectCount(String email);

    int selectNum(ShoppingCar shoppingCar);

    void clickAdd(ShoppingCar shoppingCar);

    ShoppingCar selectShoppingGoods(ShoppingCar shoppingCar);

    void clickSubtract(ShoppingCar shoppingCar);

    boolean deleteOne(ShoppingCar shoppingCar);
}
