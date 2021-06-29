package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    int id;
    String name;
    GoodsType type;
    double price;
    String unit;
    String remarks;
}
