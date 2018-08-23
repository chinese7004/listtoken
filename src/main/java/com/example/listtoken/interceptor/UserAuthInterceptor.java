package com.example.listtoken.interceptor;

import com.example.listtoken.utils.ApiUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Huoshan
 */
public class UserAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (ApiUtils.getUserInfo(request) != null) {
            return true;
        }

        response.sendRedirect("/login");
        return false;
    }
}
