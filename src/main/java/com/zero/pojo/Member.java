package com.zero.pojo;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    int id;
    String name;
    String sex; //enum
    String pwd;
    String tel;
    String addr;
    String email;
    double point;
    Boolean isVIP;
    Timestamp lastIn; //DATETIME
    Timestamp lastRe;	//DATETIME
    String remarks;
}
