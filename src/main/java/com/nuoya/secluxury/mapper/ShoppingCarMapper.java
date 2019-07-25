package com.nuoya.secluxury.mapper;

import com.nuoya.secluxury.pojo.ShoppingCar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ShoppingCarMapper {
    List<ShoppingCar> getShoppingCar(String email);

    int selectShoppingCountById(ShoppingCar shoppingCar);

    void addShopping(ShoppingCar shoppingCar);

    void updateShoppingNum(ShoppingCar shoppingCar);

    int selectNum(ShoppingCar shoppingCar);

    int selectCount(String email);

    void clickAdd(ShoppingCar shoppingCar);

    ShoppingCar selectShoppingGoods(ShoppingCar shoppingCar);

    void clickSubtract(ShoppingCar shoppingCar);

    int deleteOne(ShoppingCar shoppingCar);
}
