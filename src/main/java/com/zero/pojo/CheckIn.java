package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {
    RoomRegister roomRegister;
    int id;
    User user;
    String remarks;
    Boolean provideBreakfast;
    Boolean provideClock;
    Integer preRoomID;
}
