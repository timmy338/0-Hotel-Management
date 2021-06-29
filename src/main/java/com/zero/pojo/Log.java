package com.zero.pojo;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private int id;
    private int uid;
    private String operation;
    private Timestamp time;
    private String remarks;
}
