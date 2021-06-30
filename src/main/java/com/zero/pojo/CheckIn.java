package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {
    private Integer roomRegister;
    private Integer id;
    private Integer user;
    private String remarks;
    private Boolean provideBreakfast;
    private Boolean provideClock;
    private Integer preRoomID;
}
