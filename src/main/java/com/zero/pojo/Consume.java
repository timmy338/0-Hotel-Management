package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consume {
    Integer id;
    Integer cid;	//cost id
    Goods goods;
    Integer count;
}
