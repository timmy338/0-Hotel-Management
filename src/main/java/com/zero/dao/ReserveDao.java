package com.zero.dao;

import com.zero.pojo.Reserve;
import com.zero.pojo.RoomType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReserveDao {
    //查询客房信息请调用RoomDao接口
    /**
     * 增加预定
     * @param reserve 预定对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int insertReserve(Reserve reserve);

    /**
     * 取消预定，已入住不能删除
     * @param reserveId 预定id
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int deleteReserve(@Param("reserveId")Integer reserveId);

    /**
     * 修改预定，已入住不能修改
     * @param reserve 预定对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int UpdateReserve(Reserve reserve);

    /**
     *通过预定单号查询预定
     * @param reserveId 预定id
     * @return 返回查询到的预定列表
     */
    List<Reserve> selectReserveById(@Param("reserveId")Integer reserveId);

    /**
     *通过客房类型查询预定
     * @param roomType 客房类型
     * @return 返回查询到的预定列表
     */
    List<Reserve> selectReserveByType(@Param("roomType") String roomType);


    /**
     *通过客房编号查询预定
     * @param  roomId 客房编号
     * @return 返回查询到的预定列表
     */
    List<Reserve> selectReserveByFloor(@Param("roomId")Integer roomId);

    /**
     *通过预定状态查询预定
     * @param reserveStatus 预定状态
     * @return 返回查询到的预定列表
     */
    List<Reserve> selectReserveByStatus(@Param("reserveStatus")String reserveStatus);

    /**
     *通过预定人查询预定
     * @param reserveGuestName 预定人姓名
     * @return 返回查询到的预定列表
     */
    List<Reserve> selectReserveByName(@Param("reserveGuestName")String reserveGuestName);

    /**
     *查询预定
     * @param reserve 预定对象
     * @return 返回查询到的预定列表
     */
    List<Reserve> selectReserve(Reserve reserve);
}
