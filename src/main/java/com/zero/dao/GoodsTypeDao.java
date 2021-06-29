package com.zero.dao;

import com.zero.pojo.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTypeDao {
    /**
     * 增加商品类型
     * @param GoodsType 商品类型对象
     * @return 0表明增加失败
     */
    int insertGoodsType(GoodsType GoodsType);

    /**
     * 删除商品类型
     * @param goodsTypeId 商品类型id
     * @return 0表明删除失败
     */
    int deleteGoodsType(@Param("goodsTypeId") Integer goodsTypeId);

    /**
     * 修改商品类型
     * @param GoodsType 商品类型对象
     * @return 0表明修改失败
     */
    int updateGoodsType(GoodsType GoodsType);

    /**
     * 查询所有商品类型
     * @return 一个带有所有商品类型的List
     */
    List<GoodsType> selectAllGoodsType();
}
