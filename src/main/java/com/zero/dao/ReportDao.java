package com.zero.dao;

import org.apache.ibatis.annotations.Param;

import java.sql.Date;

public interface ReportDao {
    /**
     * 预定客人报表
     * @param min 起始日期
     * @param max 结束日期
     * @return 返回操作条数
     */
    int selectReserveMember(@Param("min") Date min,@Param("max") Date max);

    /**
     * 入住客人报表
     * @param min 起始日期
     * @param max 结束日期
     * @return 返回操作条数
     */
    int selectCheckInMember(@Param("min") Date min,@Param("max") Date max);

    /**
     * 当日预定客人报表
     * @return 返回操作条数
     */
    int selectReserveMemberToday();

    /**
     * 当日入住客人报表
     * @return 返回操作条数
     */
    int selectCheckInMemberToday();

    /**
     * 当日离店客人报表
     * @return 返回操作条数
     */
    int selectCheckOutMemberToday();

    /**
     * 当日财务进账报表
     * @return 返回操作条数
     */
    int selectFinanceToday();
}
