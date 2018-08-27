package com.example.listtoken.service.impl;

import com.example.listtoken.dao.TokenDao;
import com.example.listtoken.entity.Token;
import com.example.listtoken.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Huoshan
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenDao tokenDao;

    @Override
    public List<Token> getTokenList(Integer pageSize, Integer pageNo) {
        Integer start = (pageNo - 1) * pageSize;
        return tokenDao.getTokenList(start, pageNo);
    }
}
