package com.zero.dao;

import com.zero.pojo.RoomType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomTypeDao {
    /**
     * 增加客房类型
     * @param roomType 客房类型对象
     * @return 0表明增加失败
     */
    int insertRoomType(RoomType roomType);

    /**
     * 删除客房类型
     * @param roomTypeName 客房类型名字
     * @return 0表明删除失败
     */
    int deleteRoomType(@Param("roomTypeName") String roomTypeName);

    /**
     * 修改客房类型
     * @param roomType 客房类型对象
     * @return 0表明修改失败
     */
    int updateRoomType(RoomType roomType);

    /**
     * 查询所有客房类型
     * @return 一个带有所有房间类型的List
     */
    List<RoomType> selectAllRoomType();
}
