package com.zero.controller;

import com.zero.pojo.User;
import com.zero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public HashMap login(String uname,String pwd)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<User> userList= userService.selectUserByName(uname);
        boolean isRight=false;
        for (User u:userList) {
            if(u.getPwd().equals(pwd))
            {
                isRight=true;
                break;
            }
        }
        map.put("contains",isRight);
        return map;
    }
}
