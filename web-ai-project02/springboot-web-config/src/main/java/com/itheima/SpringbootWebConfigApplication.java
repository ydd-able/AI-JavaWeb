package com.itheima;

import com.example.EnableHeaderConfig;
import com.example.HeaderConfig;
import com.example.MyImportSelector;
import com.example.TokenParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//自动配置实现方案一： @Component + @ComponentScan
//@ComponentScan(basePackages = {"com.example","com.itheima"})

//自动配置实现方案二：@import
//@Import(TokenParser.class)
//@Import(HeaderConfig.class)
//@Import(MyImportSelector.class)//ImportSelector实现类 - 批量导入。
@EnableHeaderConfig
@SpringBootApplication//扫描启动类所在包以及子包。
public class SpringbootWebConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfigApplication.class, args);
    }


}
