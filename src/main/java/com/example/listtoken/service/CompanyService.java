package com.example.listtoken.service;

import com.example.listtoken.entity.Company;

import java.util.List;

/**
 * @author Huoshan
 */
public interface CompanyService {
    /**
     * 获取加密货币列表
     * @param pageSize
     * @param pageNo
     * @return
     */
    List<Company> getCompanyList(Integer pageSize, Integer pageNo);

    /**
     * 新建加密货币
     * @param token
     * @param userId
     */
    void create(Company token, Integer userId);

    /**
     * 更新加密货币
     * @param token
     * @param userId
     */
    void update(Company token, Integer userId);

    /**
     * 删除加密货币
     * @param id
     */
    void delete(Integer id);

    /**
     * 获取加密货币信息
     * @param id
     */
    Company get(Integer id);
}
