package com.zero.pojo;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    int id;
    int uid;
    String operation;
    Timestamp time;
    String remarks;
}
