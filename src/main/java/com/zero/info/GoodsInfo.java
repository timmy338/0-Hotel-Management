package com.zero.info;

import com.zero.pojo.Goods;
import com.zero.pojo.GoodsType;
import com.zero.service.GoodsTypeService;
import lombok.Data;

import java.util.List;

@Data
public class GoodsInfo {
    private Goods goods;
    private List<GoodsType> goodsTypeList;

    public GoodsInfo(Goods goods, GoodsTypeService goodsTypeService)
    {
        this.goods=goods;
        goodsTypeList=goodsTypeService.selectGoodsTypeById(goods.getTypeid());
    }
}
