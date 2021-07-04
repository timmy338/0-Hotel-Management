package com.zero.info;

import com.zero.pojo.Reserve;
import com.zero.pojo.RoomRegister;
import com.zero.pojo.User;
import com.zero.service.RoomRegisterService;
import com.zero.service.UserService;
import lombok.Data;

import java.util.List;

@Data
public class ReserveInfo {
    private Reserve reserve;
    private List<RoomRegister> roomRegister;
    private List<User> user;

    public ReserveInfo(Reserve src, RoomRegisterService roomRegisterService, UserService userService)
    {
        reserve=src;
        roomRegister=roomRegisterService.selectRoomRegisterById(reserve.getRoomRegister());
        user=userService.selectUserById(reserve.getUser());
    }
}
