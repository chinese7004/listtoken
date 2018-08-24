package com.example.listtoken.service;

import com.example.listtoken.entity.User;

/**
 * @author Huoshan
 */
public interface UserAuthService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 注册
     * @param username
     * @param password
     * @param operator
     * @return
     */
    void register(String username, String password, String operator);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    User getUser(String username);
}
