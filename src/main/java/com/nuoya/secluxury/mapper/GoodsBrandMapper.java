package com.nuoya.secluxury.mapper;

import com.nuoya.secluxury.pojo.GoodsBrand;
import com.nuoya.secluxury.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsBrandMapper {
    List<GoodsBrand> brandGoodsList();
}
