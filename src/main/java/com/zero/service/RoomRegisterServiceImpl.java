package com.zero.service;

import com.zero.dao.RoomRegisterDao;
import com.zero.pojo.RoomRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomRegisterServiceImpl implements RoomRegisterService{
    private final RoomRegisterDao roomRegisterDao;

    @Autowired
    public RoomRegisterServiceImpl(RoomRegisterDao roomRegisterDao) {
        this.roomRegisterDao = roomRegisterDao;
    }

    @Override
    public int insertRoomRegister(RoomRegister roomRegister) {
        return roomRegisterDao.insertRoomRegister(roomRegister);
    }

    @Override
    public int deleteRoomRegister(Integer roomRegisterId) {
        return roomRegisterDao.deleteRoomRegister(roomRegisterId);
    }

    @Override
    public int updateRoomRegister(RoomRegister roomRegister) {
        return roomRegisterDao.updateRoomRegister(roomRegister);
    }

    @Override
    public List<RoomRegister> selectRoomRegisterById(Integer id) {
        return roomRegisterDao.selectRoomRegisterById(id);
    }

    @Override
    public List<RoomRegister> selectRoomRegisterByGuestId(String guestId) {
        return roomRegisterDao.selectRoomRegisterByGuestId(guestId);
    }

    @Override
    public int selectNextAutoId() {
        return roomRegisterDao.selectNextAutoId();
    }
}
