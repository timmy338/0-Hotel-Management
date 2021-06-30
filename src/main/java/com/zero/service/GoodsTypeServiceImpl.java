package com.zero.service;

import com.zero.dao.GoodsTypeDao;
import com.zero.pojo.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsTypeServiceImpl implements GoodsTypeService{

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public int insertGoodsType(GoodsType goodsType) {
        return goodsTypeDao.insertGoodsType(goodsType);
    }

    @Override
    public int deleteGoodsType(Integer goodsTypeId) {
        return goodsTypeDao.deleteGoodsType(goodsTypeId);
    }

    @Override
    public int updateGoodsType(GoodsType goodsType) {
        return goodsTypeDao.updateGoodsType(goodsType);
    }

    @Override
    public List<GoodsType> selectAllGoodsType() {
        return goodsTypeDao.selectAllGoodsType();
    }
}
