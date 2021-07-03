package com.zero.controller;

import com.zero.pojo.Reserve;
import com.zero.service.ReserveService;
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
public class ReserveController {
    private final ReserveService reserveService;

    @Autowired
    public ReserveController(ReserveService reserveService){
        this.reserveService=reserveService;
    }

    @RequestMapping("addReserve")
    @ResponseBody
    public HashMap<String,Object> addReserve(Reserve reserve)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryAddReserve:"+reserve);
        boolean isSuccess=reserveService.insertReserve(reserve)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("getReserve")
    @ResponseBody
    public HashMap<String,Object> getReserve(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        map.put("count",reserveService.countAllReserves());
        map.put("List",reserveService.getReserve(Integer.parseInt(page)));
        return map;
    }

    @RequestMapping("delReserve")
    @ResponseBody
    public HashMap<String,Object> delReserve(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryDelReserve:ID:"+id);
        boolean isSuccess= reserveService.deleteReserve(Integer.parseInt(id))>0;
        map.put("handle",isSuccess);
        return map;
    }
}
