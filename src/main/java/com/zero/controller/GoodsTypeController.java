package com.zero.controller;

import com.zero.pojo.GoodsType;
import com.zero.pojo.User;
import com.zero.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Controller
@RestController
@CrossOrigin
public class GoodsTypeController {
    private final GoodsTypeService goodsTypeService;

    @Autowired
    public GoodsTypeController(GoodsTypeService goodsTypeService) {
        this.goodsTypeService = goodsTypeService;
    }

    @RequestMapping("getGoodsType")
    @ResponseBody
    public HashMap<String,Object> getGoodsType(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<GoodsType> GoodsTypeList= goodsTypeService.getGoodsType(Integer.parseInt(page));
        int count=goodsTypeService.countAllGoodsTypes();
        map.put("count",count);
        map.put("List",GoodsTypeList);
        return map;
    }
}
