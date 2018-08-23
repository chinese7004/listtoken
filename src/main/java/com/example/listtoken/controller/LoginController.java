package com.example.listtoken.controller;

import com.example.listtoken.entity.User;
import com.example.listtoken.service.UserAuthService;
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
public class LoginController {
    @Autowired
    private UserAuthService userAuthService;

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request) {

        User user = userAuthService.getUser(username, password);
        if (user != null) {
            request.getSession().setAttribute(ApiUtils.USER, user);
        }
        return "success";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/test")
    public String test() {
        return "Hello";
    }

}
