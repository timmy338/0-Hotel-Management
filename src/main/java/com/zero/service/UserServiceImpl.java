package com.zero.service;

import com.zero.dao.UserDao;
import com.zero.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUser(Integer userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> selectUserById(Integer userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public List<User> selectUserByName(String userName) {
        return userDao.selectUserByName(userName);
    }
}
