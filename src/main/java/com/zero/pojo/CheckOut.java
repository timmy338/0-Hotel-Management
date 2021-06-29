package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckOut {
    private CheckIn checkIn;
    private int days;
    private Cost cost;
    private double foodPrice;
    private double telPrice;
    private  double shouldPrice;
    private double shouldDeposit;
    private String wayToPay;
    private double realRecived;
    private  double giveChange;
    private  User user;
    private  String remarks;
}
