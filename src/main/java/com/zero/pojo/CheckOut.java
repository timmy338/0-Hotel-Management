package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckOut {
    private Integer id;
    private CheckIn checkIn;
    private Integer days;
    private Cost cost;
    private Double foodPrice;
    private Double telPrice;
    private  Double shouldPrice;
    private Double shouldDeposit;
    private String wayToPay;
    private Double realRecived;
    private  Double giveChange;
    private  User user;
    private  String remarks;
}
