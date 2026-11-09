package com.itheima;

import com.example.HeaderConfig;
import com.example.HeaderParser;
import com.example.TokenParser;
import com.google.gson.Gson;
import com.itheima.pojo.Result;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootWebTests {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private Gson gson;
    @Test
    public void testJson(){
        System.out.println(gson.toJson(Result.success("Hello Gson")));
    }
    @Test
    public void testScope(){
        for (int i = 0; i < 10; i++) {
            Object deptController = applicationContext.getBean("deptController");
            System.out.println(deptController);
        }
    }
//    @Autowired
//    private TokenParser tokenParser;
//
//    @Test
//    public void testTokenParser(){
//        tokenParser.parse();
//    }
    @Autowired
    private HeaderParser headerParser;
    @Test
    public void testHeaderParser(){
        headerParser.parse();

    }
}
