package com.itheima;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author N1357
 * @since 2026/9/14
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name){
        return "hello"+name+"~";
    }
}
