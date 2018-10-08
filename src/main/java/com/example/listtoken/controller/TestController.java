package com.example.listtoken.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${user.auth.openFlag}")
    private String openFlag;

    @RequestMapping("/test")
    public String test() {
        return openFlag;
    }
}
