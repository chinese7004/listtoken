package com.example.listtoken.service;

import com.example.listtoken.entity.Token;

import java.util.List;

/**
 * @author Huoshan
 */
public interface TokenService {
    /**
     * 获取加密货币列表
     * @param pageSize
     * @param pageNo
     * @return
     */
    List<Token> getTokenList(Integer pageSize, Integer pageNo);
}
