package com.zero.service;

import com.zero.dao.RoomTypeDao;
import com.zero.pojo.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService{

    private final RoomTypeDao roomTypeDao;

    @Autowired
    public RoomTypeServiceImpl(RoomTypeDao roomTypeDao){
        this.roomTypeDao=roomTypeDao;
    }

    @Override
    public int insertRoomType(RoomType roomType) {
        return roomTypeDao.insertRoomType(roomType);
    }

    @Override
    public int deleteRoomType(String roomTypeName) {
        return roomTypeDao.deleteRoomType(roomTypeName);
    }

    @Override
    public int updateRoomType(RoomType roomType) {
        return roomTypeDao.updateRoomType(roomType);
    }

    @Override
    public List<RoomType> selectAllRoomType() {
        return roomTypeDao.selectAllRoomType();
    }

    @Override
    public List<RoomType> selectRoomType(String name) {
        return roomTypeDao.selectRoomType(name);
    }

    @Override
    public List<RoomType> getRoomType(int page) {
        return roomTypeDao.getRoomType(page);
    }

    @Override
    public int countAllRoomTypes() {
        return roomTypeDao.countAllRoomTypes();
    }
}
