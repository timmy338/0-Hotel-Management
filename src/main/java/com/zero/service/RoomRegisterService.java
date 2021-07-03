package com.zero.service;

import com.zero.pojo.RoomRegister;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomRegisterService {
    /**
     *通过id查询RoomRegister
     * @param id RoomRegister的id
     * @return 返回查询到的RoomRegister列表
     */
    List<RoomRegister> selectRoomRegisterById(@Param("id")Integer id);
}
