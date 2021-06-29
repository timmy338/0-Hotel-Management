package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserve {
    RoomRegister roomRegister;
    int id;
    String status;
    User user;
    String remarks;
}
