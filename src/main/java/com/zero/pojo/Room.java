package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private Integer id;
    private RoomType type;
    private Floor floor;
    private String status;
    private Double standardPrice;
    private Double discountPrice;
    private Double memberPrice;
    private Double vipPrice;
    private String remarks;
}
