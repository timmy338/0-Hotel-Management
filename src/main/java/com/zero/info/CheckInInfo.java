package com.zero.info;

import com.zero.pojo.CheckIn;
import com.zero.pojo.RoomRegister;
import com.zero.service.RoomRegisterService;
import lombok.Data;

import java.util.List;

@Data
public class CheckInInfo {
    private CheckIn checkIn;
    private List<RoomRegister> roomRegisters;

    public CheckInInfo(CheckIn checkIn, RoomRegisterService roomRegisterService)
    {
        this.checkIn=checkIn;
        roomRegisters=roomRegisterService.selectRoomRegisterById(checkIn.getRoomRegister());
    }
}
