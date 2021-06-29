package com.zero.pojo;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRegister {
    int id;
    Room room;
    double deposit;
    String guestName;
    String guestIdType;
    String guestId;
    String tel;
    Timestamp arriveTime;
    Timestamp leaveTime;
    int guestCount;
    Integer memberId;
}
