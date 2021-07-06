package com.zero.service;

import com.zero.dao.CheckInDao;
import com.zero.dao.MemberDao;
import com.zero.dao.RoomRegisterDao;
import com.zero.pojo.CheckIn;
import com.zero.pojo.Member;
import com.zero.pojo.Room;
import com.zero.pojo.RoomRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class CheckInServiceImpl implements CheckInService{
    private final CheckInDao checkInDao;
    private final RoomRegisterDao roomRegisterDao;
    private final MemberDao memberDao;

    @Autowired
    public CheckInServiceImpl(CheckInDao checkInDao,RoomRegisterDao roomRegisterDao,MemberDao memberDao)
    {
        this.checkInDao=checkInDao;
        this.roomRegisterDao=roomRegisterDao;
        this.memberDao=memberDao;
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
        RoomRegister tempReg=roomRegisterDao.selectRoomRegisterById(checkIn.getRoomRegister()).get(0);
        if(tempReg.getMemberId()!=null)
        {
            Member tempMember=memberDao.selectMemberById(tempReg.getMemberId()).get(0);
            tempMember.setLastIn(new Timestamp(checkIn.getCheckInDate().getTime()));
            memberDao.updateMember(tempMember);
        }
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
    public List<CheckIn> selectCheckInByGuestId(Integer guestId) {
        return checkInDao.selectCheckInByGuestId(guestId);
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

    @Override
    public int delCheckIn(Integer checkInId, Integer roomId) {
        return checkInDao.delCheckIn(checkInId,roomId);
    }

    @Override
    public int countAllCheckIn() {
        return checkInDao.countAllCheckIn();
    }
}
