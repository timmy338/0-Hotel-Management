package com.zero.controller;

import com.zero.pojo.Room;
import com.zero.pojo.RoomRegister;
import com.zero.service.RoomRegisterService;
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
public class RoomRegisterController {
    private final RoomRegisterService roomRegisterService;

    @Autowired
    public RoomRegisterController(RoomRegisterService roomRegisterService){
        this.roomRegisterService=roomRegisterService;
    }

    @RequestMapping("searchRoomRegister")
    @ResponseBody
    public HashMap<String,Object> searchRoomRegister(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<RoomRegister> roomRegisterList= roomRegisterService.selectRoomRegisterById(Integer.parseInt(id));
        map.put("List",roomRegisterList);
        return map;
    }
}
