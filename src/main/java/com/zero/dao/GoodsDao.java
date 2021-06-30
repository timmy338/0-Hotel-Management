package com.zero.dao;

import com.zero.pojo.Goods;
import com.zero.pojo.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    /**
     * 增加商品
     * @param goods 商品对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
     int insertGoods(Goods goods);

    /**
     * 删除商品
     * @param goodsId 商品id
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int deleteGoods(@Param("goodsId") Integer goodsId);

    /**
     * 修改商品
     * @param goods 商品对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int  updateGoods(Goods goods);

    /**
     * 通过商品id查询商品
     * @param goodsId 商品id
     * @return 返回查询到的商品列表
     */
    List<Goods> selectGoodsById(@Param("goodsId") Integer goodsId);

    /**
     * 根据类别名查询商品
     * @param goodsTypeName 商品类别名
     * @return 返回查询到的商品列表
     */
    List<Goods> selectGoodsByType(@Param("goodsTypeName")String goodsTypeName);
}
