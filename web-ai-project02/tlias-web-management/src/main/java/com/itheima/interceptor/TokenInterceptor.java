package com.itheima.interceptor;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request1, HttpServletResponse response1, Object handler) throws Exception {

        //1.获取请求路径。
        String requestURI = request1.getRequestURI();
        //2.判断是否是登录请求，如果路径中包含/login,说明是登录操作，放行。
        if (requestURI.contains("/login")) {
            return true;
        }

        //3.获取请求头中的token
        String token = request1.getHeader("token");

        //4.判断token是否存在，如果不存在，说明用户没有登录，返回错误信息，返回错误信息(响应401).
        if (token == null || token.isEmpty()) {
            log.info("令牌为空，响应401");
            response1.setStatus(401);
            return false;
        }

        //5.如果令牌存在，校验令牌-》校验失败-》返回错误信息(响应401)
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法。");
            response1.setStatus(401);
            return false;
        }

        //6.校验通过，放行。
        log.info("令牌合法，放行。");
        return true;
    }

}

