package com.zero.info;

import com.zero.pojo.CheckIn;
import com.zero.pojo.Room;
import com.zero.pojo.RoomRegister;
import com.zero.service.RoomRegisterService;
import com.zero.service.RoomService;
import lombok.Data;

import java.util.List;

@Data
public class CheckInInfo {
    private CheckIn checkIn;
    private List<RoomRegister> roomRegisters;
    private List<Room> rooms;

    public CheckInInfo(CheckIn checkIn, RoomRegisterService roomRegisterService, RoomService roomService)
    {
        this.checkIn=checkIn;
        roomRegisters=roomRegisterService.selectRoomRegisterById(checkIn.getRoomRegister());
        rooms=roomService.selectRoom(roomRegisters.get(0).getRoom());
    }
}
