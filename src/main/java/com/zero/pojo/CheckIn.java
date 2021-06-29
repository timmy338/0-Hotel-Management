package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {
    private RoomRegister roomRegister;
    private Integer id;
    private User user;
    private String remarks;
    private Boolean provideBreakfast;
    private Boolean provideClock;
    private Integer preRoomID;
}
