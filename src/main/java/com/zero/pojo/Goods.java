package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private int id;
    private String name;
    private GoodsType type;
    private double price;
    private String unit;
    private String remarks;
}
