package com.zero.pojo;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private int id;
    private String name;
    private String sex; //enum
    private String pwd;
    private String tel;
    private String addr;
    private String email;
    private double point;
    private Boolean isVIP;
    private Timestamp lastIn; //DATETIME
    private Timestamp lastRe;	//DATETIME
    private String remarks;
}
