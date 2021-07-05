package com.zero.controller;

import com.zero.info.CheckInInfo;
import com.zero.info.ReserveInfo;
import com.zero.pojo.CheckIn;
import com.zero.pojo.Reserve;
import com.zero.service.CheckInService;
import com.zero.service.RoomRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RestController
@CrossOrigin
public class CheckInController {
    private final CheckInService checkInService;
    private final RoomRegisterService roomRegisterService;

    @Autowired
    public CheckInController(CheckInService checkInService,RoomRegisterService roomRegisterService)
    {
        this.checkInService=checkInService;
        this.roomRegisterService=roomRegisterService;
    }

    @RequestMapping("addCheckIn")
    @ResponseBody
    public HashMap<String,Object> addCheckIn(CheckIn checkInInfo)
    {
        boolean handle=checkInService.insertCheckIn(checkInInfo)>0;
        HashMap<String,Object> map=new HashMap<>();
        map.put("handle",handle);
        return map;
    }

    @RequestMapping("changeRoom")
    @ResponseBody
    public HashMap<String,Object> changeRoom(String checkInId,String roomId)
    {
        HashMap<String,Object> map=new HashMap<>();
        boolean handle=checkInService.changeRoom(Integer.parseInt(checkInId),Integer.parseInt(roomId))>0;
        map.put("handle",handle);
        return map;
    }

//    @RequestMapping("getCheckInByRoomRegister")
//    @ResponseBody
//    public HashMap<String,Object> getCheckInByRoomRegister(String id)
//    {
//        HashMap<String,Object> map=new HashMap<>();
//        List<CheckIn> checkInList=checkInService.selectCheckInByRoomRegister(Integer.parseInt(id));
//        map.put("List",checkInList);
//        return map;
//    }

    @RequestMapping("getCheckIn")
    @ResponseBody
    public HashMap<String,Object> getCheckIn(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<CheckInInfo> checkInInfoList=new ArrayList<>();
        List<CheckIn> checkInList=checkInService.getCheckIn(Integer.parseInt(page));
        for(CheckIn c:checkInList)
            checkInInfoList.add(new CheckInInfo(c,roomRegisterService));
        map.put("List",checkInInfoList);
        return map;
    }
}
