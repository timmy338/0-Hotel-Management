package com.zero.service;

import com.zero.dao.RoomRegisterDao;
import com.zero.pojo.RoomRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomRegisterImpl implements RoomRegisterService{
    private final RoomRegisterDao roomRegisterDao;

    @Autowired
    public RoomRegisterImpl(RoomRegisterDao roomRegisterDao) {
        this.roomRegisterDao = roomRegisterDao;
    }

    @Override
    public List<RoomRegister> selectRoomRegisterById(Integer id) {
        return roomRegisterDao.selectRoomRegisterById(id);
    }
}
