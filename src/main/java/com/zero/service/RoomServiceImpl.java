package com.zero.service;

import com.zero.dao.RoomDao;
import com.zero.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{
    private final RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao){
        this.roomDao=roomDao;
    }

    @Override
    public int insertRoom(Room room) {
        return roomDao.insertRoom(room);
    }

    @Override
    public int deleteRoom(Integer roomId) {
        return roomDao.deleteRoom(roomId);
    }

    @Override
    public int updateRoom(Room room) {
        return roomDao.updateRoom(room);
    }

    @Override
    public List<Room> selectRoomById(Integer roomId) {
        return roomDao.selectRoomById(roomId);
    }

    @Override
    public List<Room> selectRoomByType(String roomType) {
        return roomDao.selectRoomByType(roomType);
    }

    @Override
    public List<Room> selectRoomByStatus(String roomStatus) {
        return roomDao.selectRoomByStatus(roomStatus);
    }

    @Override
    public List<Room> selectRoomByFloor(String floor) {
        return roomDao.selectRoomByFloor(floor);
    }

    @Override
    public List<Room> selectRoomByPrice(Double roomPrice) {
        return roomDao.selectRoomByPrice(roomPrice);
    }

    @Override
    public List<Room> selectRoom(Room room) {
        return roomDao.selectRoom(room);
    }

    @Override
    public List<Room> getRoom(int page) {
        int offset =6*(page-1);
        return roomDao.getRoom(offset);
    }

    @Override
    public int countAllRooms() {
        return roomDao.countAllRooms();
    }
}
