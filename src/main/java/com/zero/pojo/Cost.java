package com.zero.pojo;

import java.sql.Timestamp;
import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cost {
    private Integer id;
    private CheckIn checkIn;
    private HashMap<Goods,Integer> goodsList;
    private Double price;
    private Double discount;
    private Double discountPrice;
    private Double totalPrice;
    private User user;
    private Timestamp time;
    private String remarks;
}
