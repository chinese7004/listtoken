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

    /**
     * 新建加密货币
     * @param token
     * @param userId
     */
    void create(Token token, Integer userId);

    /**
     * 更新加密货币
     * @param token
     * @param userId
     */
    void update(Token token, Integer userId);

    /**
     * 删除加密货币
     * @param id
     */
    void delete(Integer id);

    /**
     * 获取加密货币信息
     * @param id
     */
    Token get(Integer id);
}
