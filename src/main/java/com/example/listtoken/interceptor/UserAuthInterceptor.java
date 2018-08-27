package com.example.listtoken.interceptor;

import com.example.listtoken.utils.ApiUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Huoshan
 */
@Component
public class UserAuthInterceptor implements HandlerInterceptor {
    @Value("${user.auth.openFlag}")
    private String openFlag;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("false".equals(openFlag)) {
            return true;
        }

        if (ApiUtils.getUserInfo(request) != null) {
            return true;
        }

        response.sendRedirect("/login.html");
        return false;
    }
}
