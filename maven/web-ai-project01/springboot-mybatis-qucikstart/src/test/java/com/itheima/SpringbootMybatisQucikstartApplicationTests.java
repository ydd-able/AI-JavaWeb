package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQucikstartApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void testDeleteId() {
        userMapper.deleteById(2);
    }

    @Test
    public void testInsert() {
        User user = new User(1, "heima", "123456", "张三", 18);
        userMapper.insert(user);
    }

    @Test
    public void testUpdate() {
        User user = new User(1, "heima1", "1234567", "yao", 19);
        userMapper.update(user);
    }

    @Test
    public void testFindByUsernameAndPassword() {
        User user = userMapper.findByUsernameAndPassword("heima", "123456");
        System.out.println(user);
    }

}
