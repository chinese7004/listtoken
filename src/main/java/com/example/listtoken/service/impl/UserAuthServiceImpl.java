package com.example.listtoken.service.impl;

import com.example.listtoken.dao.UserAuthDao;
import com.example.listtoken.entity.User;
import com.example.listtoken.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author Huoshan
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {
    @Autowired
    private UserAuthDao userAuthDao;

    @Override
    public User getUser(String username, String password) {
        User user = userAuthDao.getUser(username);
        if (user == null) {
            return null;
        }

        if (DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            return user;
        }

        return null;
    }
}
