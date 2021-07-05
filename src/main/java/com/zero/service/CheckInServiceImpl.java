package com.zero.service;

import com.zero.dao.CheckInDao;
import com.zero.pojo.CheckIn;
import com.zero.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CheckInServiceImpl implements CheckInService{
    private final CheckInDao checkInDao;

    @Autowired
    public CheckInServiceImpl(CheckInDao checkInDao)
    {
        this.checkInDao=checkInDao;
    }

    @Override
    public List<Room> selectRoomById(Integer roomId) {
        return checkInDao.selectRoomById(roomId);
    }

    @Override
    public List<Room> selectRoomByType(String roomType) {
        return checkInDao.selectRoomByType(roomType);
    }

    @Override
    public List<Room> selectRoomByStatus(String roomStatus) {
        return checkInDao.selectRoomByStatus(roomStatus);
    }

    @Override
    public List<Room> selectRoomByFloor(String floor) {
        return checkInDao.selectRoomByFloor(floor);
    }

    @Override
    public List<Room> selectRoomByPrice(double roomPrice) {
        return checkInDao.selectRoomByPrice(roomPrice);
    }

    @Override
    public int insertCheckIn(CheckIn checkIn) {
        return checkInDao.insertCheckIn(checkIn);
    }

    @Override
    public List<CheckIn> selectCheckInById(Integer checkInId) {
        return checkInDao.selectCheckInById(checkInId);
    }

    @Override
    public List<CheckIn> selectCheckInByRoomType(String roomType) {
        return checkInDao.selectCheckInByRoomType(roomType);
    }

    @Override
    public List<CheckIn> selectCheckInByRoomId(Integer roomId) {
        return checkInDao.selectCheckInByRoomId(roomId);
    }

    @Override
    public List<CheckIn> selectCheckInByUser(String guest) {
        return checkInDao.selectCheckInByUser(guest);
    }

    @Override
    public List<CheckIn> selectCheckInByRoomRegister(Integer id) {
        return checkInDao.selectCheckInByRoomRegister(id);
    }

    @Override
    public List<CheckIn> getCheckIn(Integer page) {
        return checkInDao.getCheckIn(6*(page-1));
    }

    @Override
    public int changeRoom(Integer checkInId, Integer roomId) {
        return checkInDao.changeRoom(checkInId,roomId);
    }
}
