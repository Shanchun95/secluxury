package com.nuoya.secluxury.service.impl;

import com.nuoya.secluxury.mapper.ShoppingCarMapper;
import com.nuoya.secluxury.pojo.ShoppingCar;
import com.nuoya.secluxury.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Autowired
    ShoppingCarMapper shoppingCarMapper;

    @Override
    public List<ShoppingCar> getShoppingCar(String email) {
        List<ShoppingCar> shoppingCarList = shoppingCarMapper.getShoppingCar(email);
        return shoppingCarList;
    }

    @Override
    public int selectShoppingCountById(ShoppingCar shoppingCar) {
        int result = shoppingCarMapper.selectShoppingCountById(shoppingCar);
        return result;
    }

    @Override
    public void addShopping(ShoppingCar shoppingCar) {
        shoppingCarMapper.addShopping(shoppingCar);
    }

    @Override
    public int selectNum(ShoppingCar shoppingCar) {
        return shoppingCarMapper.selectNum(shoppingCar);
    }

    @Override
    public void clickAdd(ShoppingCar shoppingCar) {
        shoppingCarMapper.clickAdd(shoppingCar);
    }

    @Override
    public ShoppingCar selectShoppingGoods(ShoppingCar shoppingCar) {
        shoppingCar = shoppingCarMapper.selectShoppingGoods(shoppingCar);
        return shoppingCar;
    }

    @Override
    public void clickSubtract(ShoppingCar shoppingCar) {
        shoppingCarMapper.clickSubtract(shoppingCar);
    }

    @Override
    public boolean deleteOne(ShoppingCar shoppingCar) {
        int result = shoppingCarMapper.deleteOne(shoppingCar);
        return result == 1 ? true : false;
    }

    @Override
    public void updateShoppingNum(ShoppingCar shoppingCar) {
        shoppingCarMapper.updateShoppingNum(shoppingCar);
    }

    @Override
    public int selectCount(String email) {
        int result = shoppingCarMapper.selectCount(email);
        return result;
    }


}
