package com.zero.service;

import com.zero.dao.ReserveDao;
import com.zero.pojo.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReserveServiceImpl implements ReserveService{
    private final ReserveDao reserveDao;

    @Autowired
    public ReserveServiceImpl(ReserveDao reserveDao){
        this.reserveDao=reserveDao;
    }

    @Override
    public int insertReserve(Reserve reserve) {
        return reserveDao.insertReserve(reserve);
    }

    @Override
    public int deleteReserve(Integer reserveId) {
        return reserveDao.deleteReserve(reserveId);
    }

    @Override
    public int UpdateReserve(Integer id) {
        return reserveDao.UpdateReserve(id);
    }

    @Override
    public List<Reserve> selectReserveById(Integer reserveId) {
        return reserveDao.selectReserveById(reserveId);
    }

    @Override
    public List<Reserve> selectReserveByType(String roomType) {
        return reserveDao.selectReserveByType(roomType);
    }

    @Override
    public List<Reserve> selectReserveByFloor(String floor) {
        return reserveDao.selectReserveByFloor(floor);
    }

    @Override
    public List<Reserve> selectReserveByStatus(String reserveStatus) {
        return reserveDao.selectReserveByStatus(reserveStatus);
    }

    @Override
    public List<Reserve> selectReserveByName(String reserveGuestName) {
        return reserveDao.selectReserveByName(reserveGuestName);
    }

    @Override
    public List<Reserve> getReserve(int page) {
        return reserveDao.getReserve(6*(page-1));
    }

    @Override
    public int countAllReserves() {
        return reserveDao.countAllReserves();
    }

    @Override
    public List<Reserve> selectReserveByRoomId(Integer roomId) {
        return reserveDao.selectReserveByRoomId(roomId);
    }
}
