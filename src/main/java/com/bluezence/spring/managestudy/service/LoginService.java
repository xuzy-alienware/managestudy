package com.bluezence.spring.managestudy.service;

import com.bluezence.spring.managestudy.dao.UserDao;
import com.bluezence.spring.managestudy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    public User getUser(){
        userDao.getUserCount();
        User user = new User();
        user.setName("xuzy5");
        user.setId(2);
        return user;
    }

    public int getUserCount(){
        return userDao.getUserCount();
    }
}
