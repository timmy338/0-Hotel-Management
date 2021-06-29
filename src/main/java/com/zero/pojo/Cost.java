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
    private CheckIn checkIn;
    private HashMap<Goods,Integer> goodsList;
    private double price;
    private double discount;
    private double discountPrice;
    private double toutalPrice;
    private User user;
    private Timestamp time;
    private String remarks;
}
