package com.zero.dao;

import com.zero.pojo.Floor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FloorDao {
    /**
     *增加楼层
     * @param floor 楼层对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int insertFloor(Floor floor);

    /**
     *删除楼层
     * @param floorName 楼层名
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int deleteFloor(@Param("floorName")String floorName);

    /**
     *修改楼层
     * @param floorName 楼层名
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int updateFloor(@Param("floorName") String floorName);

    /**
     * 查寻楼层
     * @param floorName 楼层名
     * @return 返回查询到的楼层列表
     */
    List<Floor> selectFloor(@Param("floorName") String floorName);
}
