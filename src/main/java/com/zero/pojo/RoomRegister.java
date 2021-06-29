package com.zero.pojo;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRegister {
    private int id;
    private Room room;
    private double deposit;
    private String guestName;
    private String guestIdType;
    private String guestId;
    private String tel;
    private Timestamp arriveTime;
    private Timestamp leaveTime;
    private int guestCount;
    private Integer memberId;
}
