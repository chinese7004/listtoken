//package com.example.listtoken;
//
//import com.alibaba.fastjson.JSON;
//import com.example.listtoken.entity.Token;
//import com.example.listtoken.service.TokenService;
//import com.example.listtoken.service.UserAuthService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ListtokenApplicationTests {
//    @Autowired
//    private UserAuthService userAuthService;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @Test
//    public void loginTest() {
//
//    }
//
//    @Test
//    public void registerTest() {
//        String username = "huoshan2";
//        String password = "1";
//        String operator = "sys";
//        userAuthService.register(username, password, operator);
//    }
//
//    @Test
//    public void getTokenListTest() {
//        Integer pageSize = 10;
//        Integer pageNo = 1;
//        List<Token> tokenList = tokenService.getTokenList(pageSize, pageNo);
//        System.out.println(JSON.toJSONString(tokenList));
//    }
//
//    @Test
//    public void createTokenTest() {
//        Token token = new Token();
//        token.setCompanyId(1);
//        token.setName("testToken");
//        token.setSymbol("ea2");
//        token.setType("1");
//        tokenService.create(token, 2);
//    }
//
//    @Test
//    public void updateTokenTest() {
//        Token token = new Token();
//        token.setId(3);
//        token.setCompanyId(1);
//        token.setName("testToken");
//        token.setSymbol("ea2");
//        token.setType("1");
//        tokenService.update(token, 2);
//    }
//
//    @Test
//    public void deleteTokenTest() {
//        Integer id = 2;
//        tokenService.delete(id);
//    }
//
//    @Test
//    public void getTokenTest() {
//        Integer id = 3;
//        Token token = tokenService.get(id);
//        System.out.println(JSON.toJSONString(token));
//    }
//}
