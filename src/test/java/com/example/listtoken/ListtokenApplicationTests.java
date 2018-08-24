package com.example.listtoken;

import com.example.listtoken.service.UserAuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListtokenApplicationTests {
    @Autowired
    private UserAuthService userAuthService;

    @Test
    public void loginTest() {

    }

    @Test
    public void registerTest() {
        String username = "huoshan2";
        String password = "1";
        String operator = "sys";
        userAuthService.register(username, password, operator);
    }

}
