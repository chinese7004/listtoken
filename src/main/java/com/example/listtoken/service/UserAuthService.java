package com.example.listtoken.service;

import com.example.listtoken.entity.User;

/**
 * @author Huoshan
 */
public interface UserAuthService {
    /**
     * 获取用户信息
     * @param username
     * @param password
     * @return
     */
    User getUser(String username, String password);
}
