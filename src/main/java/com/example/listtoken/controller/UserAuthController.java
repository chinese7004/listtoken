package com.example.listtoken.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.listtoken.entity.User;
import com.example.listtoken.service.UserAuthService;
import com.example.listtoken.utils.ApiMessageFormatUtil;
import com.example.listtoken.utils.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Huoshan
 */
@RestController
@RequestMapping("/auth")
public class UserAuthController {
    @Autowired
    private UserAuthService userAuthService;

    @RequestMapping("/login")
    public JSONObject login(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpServletRequest request) {
        JSONObject resJson = new JSONObject();

        User user = userAuthService.login(username, password);
        if (user != null) {
            request.getSession().setAttribute(ApiUtils.USER, user);
        }

        ApiMessageFormatUtil.formatJson(resJson);
        return resJson;
    }

    @RequestMapping("/register")
    public JSONObject register(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam("repeat") String repeat,
                      @RequestParam(value = "operator", required = false, defaultValue = "sys") String operator,
                      HttpServletRequest request) {
        JSONObject resJson = new JSONObject();

        if (!password.equals(repeat)) {
            ApiMessageFormatUtil.formatJsonError(resJson, "Password do not match.");
            return resJson;
        }

        try {
            userAuthService.register(username, password, operator);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
        }

        User user = userAuthService.login(username, password);
        if (user != null) {
            request.getSession().setAttribute(ApiUtils.USER, user);
        }

        ApiMessageFormatUtil.formatJson(resJson);
        return resJson;
    }

}
