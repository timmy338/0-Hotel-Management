package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    int id;
    RoomType type;
    Floor floor;
    String status;
    double standardPrice;
    double discountPrice;
    double memberPrice;
    double vipPrice;
    String remarks;
}
