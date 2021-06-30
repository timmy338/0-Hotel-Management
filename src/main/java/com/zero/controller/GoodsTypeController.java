package com.zero.controller;

import com.zero.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@CrossOrigin
public class GoodsTypeController {
    @Autowired
    private GoodsTypeService goodsTypeService;


}
