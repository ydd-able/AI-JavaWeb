package com.itheima;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author N1357
 * @since 2026/9/14
 */
@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        //获取请求方式
        String method = request.getMethod();
        System.out.println("\"请求方式\" = " + "请求方式");
        //获取请求路径。
        String requestURI = request.getRequestURI();
        //获取请求协议
        String protocol = request.getProtocol();
        //获取请求参数    -name
        String name = request.getParameter("name");

        //获取请求头 -Accept
        String accept = request.getHeader("Accept");
        return "ok";
    }
}
