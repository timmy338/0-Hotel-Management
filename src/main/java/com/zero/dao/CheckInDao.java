package com.zero.dao;

import com.zero.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckInDao {
    List<Room> selectRoomById(@Param("roomId")Integer roomId);

    /**
     *通过类型查询客房
     * @param roomType 客房类型
     * @return 返回查询到的客房列表
     */
    List<Room> selectRoomByType(RoomType roomType);

    /**
     *通过状态查询客房
     * @param roomStatus 客房状态
     * @return 返回查询到的客房列表
     */
    List<Room> selectRoomByStatus(@Param("roomStatus")String roomStatus);

    /**
     *通过楼层查询客房
     * @param floor 楼层对象
     * @return 返回查询到的客房列表
     */
    List<Room> selectRoomByFloor(Floor floor);

    /**
     *通过价格查询客房
     * @param roomPrice 客房价格
     * @return 返回查询到的客房列表
     */
    List<Room> selectRoomByPrice(@Param("roomPrice")double roomPrice);

    /**
     *查询客房
     * @param room 客房对象
     * @return 返回查询到的客房列表
     */
    List<Room> selectRoom(Room room);

    /**
     * 填写入住信息
     * @param checkIn 入住对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int fillCheckIn(CheckIn checkIn);

//    /**
//     * 打印入住单
//     * @param checkIn 入住对象
//     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
//     */
//    int printCheckIn(CheckIn checkIn);

    /**
     * 保存登记信息
     * @param checkIn 入住对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int saveCheckIn(CheckIn checkIn);

    /**
     *根据入住单号查询入住客房信息
     * @param checkInId 入住单号
     * @return 返回查询到的客房信息列表
     */
    List<CheckIn> selectCheckInById(@Param("checkInId")Integer checkInId);

    /**
     *根据客房类型查询入住客房信息
     * @param roomType 客房类型
     * @return 返回查询到的客房信息列表
     */
    List<CheckIn> selectCheckInByRoomType(@Param("roomType") String roomType);

    /**
     *根据客房编号查询入住客房信息
     * @param roomId 客房编号
     * @return 返回查询到的客房信息列表
     */
    List<CheckIn> selectCheckInByRoomId(@Param("roomId")Integer roomId);

    /**
     *根据入住人查询入住客房信息
     * @param user 入住人对象
     * @return 返回查询到的客房信息列表
     */
    List<CheckIn> selectCheckInByUser(@Param("user") Integer user);

    /**
     * 预定转入住
     * @param reserve 预定对象
     * @return 入住后的CheckIn列表
     * */
    List<CheckIn> reserveToCheckIn(Reserve reserve);

    /**
     * 换房
     * @param checkIn 需要更改的CheckIn对象
     * @param room 更改后的room
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int changeRoom(CheckIn checkIn,Room room);
}
