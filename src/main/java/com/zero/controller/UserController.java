package com.zero.controller;

import com.zero.pojo.User;
import com.zero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping("login")
//    public ModelAndView login(User user)
//    {
//        ModelAndView mv =new ModelAndView();
//
//    }
}
