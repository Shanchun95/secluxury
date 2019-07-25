package com.nuoya.secluxury.controller;

import com.nuoya.secluxury.pojo.ShoppingCar;
import com.nuoya.secluxury.service.GoodsService;
import com.nuoya.secluxury.service.ShoppingCarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shoppingcar")
public class ShoppingCarController {

    @Autowired
    ShoppingCarService shoppingCarService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/getshoppingcar")
    @ApiOperation("点击我的购物车，传入用户的email，则展示该用户所有购物车内容")
    public List<ShoppingCar> getShoppingCar(HttpServletResponse response, String email) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<ShoppingCar> shoppingCarList = shoppingCarService.getShoppingCar(email);
        for (ShoppingCar shop:
             shoppingCarList) {
            shop.setTotalPrice(shop.getNum() * shop.getGoods().getGoodsPrice());
        }
        System.out.println(shoppingCarList);

        return shoppingCarList;
    }

    @RequestMapping("/addShopping")
    @ApiOperation("当在商品详情页点击‘加入购物车’时，从前台传入商品id、email，这个方法就加入一条商品信息到个人，并返回购物车总数")
    public int addShopping(String email,int shoppingGoodsId) {
        //用这个方法返回一个数值，表示购物车中这个商品的数量,这里参数用到了商品id和用户email
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setEmail(email);
        shoppingCar.setShoppingGoodsId(shoppingGoodsId);
        int result = shoppingCarService.selectShoppingCountById(shoppingCar);
        System.out.println("购物车中这个商品的数量+++++++"+result);
        if (result <= 0) {
            //数量不为0，那么我们就加一条数据到数据库，
            shoppingCarService.addShopping(shoppingCar);
        } else {
            //数量不为0，我们就修改购物车中该商品的数量，实现+1
            int num = shoppingCarService.selectNum(shoppingCar);
            shoppingCar.setNum(num+1);
            shoppingCarService.updateShoppingNum(shoppingCar);
        }
        //查询购物车商品条数
        int totalNum = shoppingCarService.selectCount(email);
        System.out.println(totalNum);
        return totalNum;
    }

    @RequestMapping("/clickadd")
    @ApiOperation("购物车页面中点击‘+’号，传入商品id、用户email实现该商品数量加1")
    public ShoppingCar clickAdd(String email, int shoppingGoodsId) {
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setEmail(email);
        shoppingCar.setShoppingGoodsId(shoppingGoodsId);
        shoppingCarService.clickAdd(shoppingCar);
        //查询这个商品的num和价格
        shoppingCar = shoppingCarService.selectShoppingGoods(shoppingCar);
        System.out.println("这是点击‘+’查询到的值"+shoppingCar);
        return shoppingCar;
    }

    @RequestMapping("/clicksubtract")
    @ApiOperation("购物车页面中点击‘-’号，传入商品id、用户email实现该商品数量减1")
    public ShoppingCar clickSubtract(String email, int shoppingGoodsId) {
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setEmail(email);
        shoppingCar.setShoppingGoodsId(shoppingGoodsId);
        shoppingCarService.clickSubtract(shoppingCar);
        //查询这个商品的num和价格
        shoppingCar = shoppingCarService.selectShoppingGoods(shoppingCar);
        System.out.println("这是点击‘-’查询到的值"+shoppingCar);
        return shoppingCar;
    }

    @RequestMapping("/deleteone")
    @ApiOperation("删除一条购物车数据，需要传入这条数据的商品id和用户email")
    public boolean deleteOne(String email,int shoppingGoodsId) {
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setEmail(email);
        shoppingCar.setShoppingGoodsId(shoppingGoodsId);
        boolean result = shoppingCarService.deleteOne(shoppingCar);
        return result;
    }



}
