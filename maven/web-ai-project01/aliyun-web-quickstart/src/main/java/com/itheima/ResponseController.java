package com.itheima;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author N1357
 * @since 2026/9/14
 */
@RestController
public class ResponseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) {
        //1.设置响应状态码
        response.setStatus(200);

        //2.设置响应头
        response.setHeader("name","itcast");
        //3.设置响应体
        try {
            response.getWriter().write("<h1>hello response</h1>");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/response2")
    public ResponseEntity<String> response2(){
            return ResponseEntity.status(401).
                    header("name","javaweb-ai").
                    body("<h1>hello response</h1>");
    }
}
