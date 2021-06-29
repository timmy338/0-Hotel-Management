package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserve {
    private RoomRegister roomRegister;
    private int id;
    private String status;
    private User user;
    private String remarks;
}
