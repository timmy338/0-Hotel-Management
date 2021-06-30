package com.zero.dao;

import com.zero.pojo.Floor;
import com.zero.pojo.Room;
import com.zero.pojo.RoomType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomDao {
    /**
     * 增加客房
     * @param room 客房对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int insertRoom(Room room);

    /**
     * 删除客房
     * @param roomId 客房id
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int deleteRoom(@Param("roomId")Integer roomId);

    /**
     * 修改客房
     * @param roomId 客房id
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int UpdateRoom(@Param("roomId")Integer roomId);

    /**
     *通过编号查询客房
     * @param roomId 客房id
     * @return 返回查询到的客房列表
     */
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
}