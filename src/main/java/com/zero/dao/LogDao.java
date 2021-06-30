package com.zero.dao;

import com.zero.pojo.Log;
import com.zero.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface LogDao {
    /**
     * 从时间段和用户查询日志
     * @param min 起始时间
     * @param max 终止时间
     * @param uid 用户id
     * @return 满足条件的日志
     */
    List<Log> selectLogByTimeAndUser(@Param("min") Timestamp min, @Param("max") Timestamp max,Integer uid);

    /**
     * 从时间段删除日志
     * @param min 起始时间
     * @param max 终止时间
     * @return 0表示删除失败
     */
    int deleteLogByTime(@Param("min") Timestamp min,@Param("max") Timestamp max);
}
