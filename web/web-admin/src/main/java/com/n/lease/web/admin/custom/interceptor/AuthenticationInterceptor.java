package com.n.lease.web.admin.custom.interceptor;

import com.n.lease.common.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
//身份验证拦截器
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //获取token
        String token = request.getHeader("access-token");
        JwtUtil.parseToken(token);
        //如果token异常在上一行就抛异常
        return true;
    }
}
