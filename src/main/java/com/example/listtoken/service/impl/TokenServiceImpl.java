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

    @Override
    public void create(Token token, Integer userId) {
        Token token1 = tokenDao.getTokenBySymbol(token.getSymbol());
        if (token1 != null) {
            throw new RuntimeException("Symbol exists.");
        }

        tokenDao.create(token, userId);
    }

    @Override
    public void update(Token token, Integer userId) {
        Token token1 = tokenDao.getTokenById(token.getId());
        if (token1 == null) {
            throw new RuntimeException("Token does not exist.");
        }

        token1 = tokenDao.getTokenBySymbol(token.getSymbol());
        if (token1 != null) {
            throw new RuntimeException("Symbol exists.");
        }

        tokenDao.update(token, userId);
    }

    @Override
    public void delete(Integer id) {
        Token token = tokenDao.getTokenById(id);
        if (token == null) {
            throw new RuntimeException("Token does not exist.");
        }

        tokenDao.delete(id);
    }

    @Override
    public Token get(Integer id) {
        Token token = tokenDao.getTokenById(id);
        if (token == null) {
            throw new RuntimeException("Token does not exist.");
        }
        return token;
    }
}
