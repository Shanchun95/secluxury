package com.nuoya.secluxury.mapper;

import com.nuoya.secluxury.pojo.GoodsBrand;
import com.nuoya.secluxury.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsBrandMapper {
    List<GoodsBrand> brandGoodsList();
}
