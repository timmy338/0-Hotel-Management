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
    CheckIn checkIn;
    HashMap<Goods,Integer> goodsList;
    double price;
    double discount;
    double discountPrice;
    double toutalPrice;
    User user;
    Timestamp time;
    String remarks;
}
