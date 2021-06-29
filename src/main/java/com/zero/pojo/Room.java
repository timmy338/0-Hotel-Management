package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private int id;
    private RoomType type;
    private Floor floor;
    private String status;
    private double standardPrice;
    private double discountPrice;
    private double memberPrice;
    private double vipPrice;
    private String remarks;
}
