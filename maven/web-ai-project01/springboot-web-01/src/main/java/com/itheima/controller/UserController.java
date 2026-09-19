package com.itheima.controller;

import cn.hutool.core.io.IoUtil;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author N1357
 * @since 2026/9/14
 */
@RestController
public class UserController {
    //方式一：属性注入。
    @Autowired //自动装配，byType
    private UserService userService;

    //构造器注入
//    private final UserServiceImpl userService;
//    @Autowired
//    public UserController(UserServiceImpl userService) {
//        this.userService = userService;
//    }
//    //set方法注入
//    private UserServiceImpl userService;
//    @Autowired
//    public void setUserService(UserServiceImpl userService){
//        this.userService = userService;
//    }
    @RequestMapping("/list")
    public List<User> list() throws FileNotFoundException {
        //加载并读取user.txt文件，获取用户数据。
        //InputStream in = new FileInputStream(new File("D:\\java\\work_space\\AI+JavaWeb\\maven\\web-ai-project01\\springboot-web-01\\src\\main\\resources\\user.txt"));
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        ArrayList<String> lines = IoUtil.readLines(in, "utf-8", new ArrayList<>());
//
//        //解析用户信息，封装为user对象。->list集合。
//        List<User> list = lines.stream().map(line -> {
//            String[] parts = line.split(",");
//            Integer id = Integer.parseInt(parts[0]);
//            String username = parts[1];
//            String password = parts[2];
//            String name = parts[3];
//            Integer age = Integer.parseInt(parts[4]);
//            LocalDateTime createTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            return new User(id, username, password, name, age, createTime);
//
//        }).toList();
//        return list;

        List<User> userList= userService.findAll();
        return userList;



    }

}
