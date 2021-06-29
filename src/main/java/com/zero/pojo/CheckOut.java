package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckOut {
    CheckIn checkIn;
    int days;
    Cost cost;
    double foodPrice;
    double telPrice;
    double shouldPrice;
    double shouldDeposit;
    String wayToPay;
    double realRecived;
    double giveChange;
    User user;
    String remarks;
}
