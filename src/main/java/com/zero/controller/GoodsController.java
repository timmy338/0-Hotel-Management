package com.zero.controller;
import com.zero.pojo.Goods;
import com.zero.service.GoodsService;
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
public class GoodsController {
    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService){
        this.goodsService=goodsService;
    }

    @RequestMapping("getGoods")
    @ResponseBody
    public HashMap<String,Object> getGoods(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<Goods> goodsList= goodsService.getGoods(Integer.parseInt(page));
        int count=goodsService.countAllGoods();
        map.put("count",count);
        map.put("List",goodsList);
        return map;
    }

    @RequestMapping("delGoods")
    @ResponseBody
    public HashMap<String,Object> delGoods(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryDelGoods:ID:"+id);
        boolean isSuccess= goodsService.deleteGoods(Integer.parseInt(id))>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("addGoods")
    @ResponseBody
    public HashMap<String,Object> addGoods(Goods goods)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryAddGoods:"+goods);
        boolean isSuccess=goodsService.insertGoods(goods)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("editGoods")
    @ResponseBody
    public HashMap<String,Object> editGoods(Goods goods)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryUpdateGoods:"+goods);
        boolean isSuccess=goodsService.updateGoods(goods)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("searchGoods")
    @ResponseBody
    public HashMap<String,Object> searchGoods(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<Goods> GoodsList= goodsService.selectGoodsById(Integer.parseInt(id));
        map.put("List",GoodsList);
        return map;
    }
}
