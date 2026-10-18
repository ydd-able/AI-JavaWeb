package com.itheima;

import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author N1357
 * @since 2026/9/21
 */
public class JdbcTest {
    @Test
    public void testUpdate() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.数据库连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web01", "root", "Bama5201314.,.,");
        //3.获取sql语句执行对象。
        Statement statement = connection.createStatement();
        //4.执行sql
        int i = statement.executeUpdate("update user set age = 28 where id = 1");
        //5.释放资源。
        statement.close();
        connection.close();

    }
        @Test
        public void testQuery () throws Exception {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/web01", "root", "Bama5201314.,.,");

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(
                    "select id,username,password,name,age from user where username = 'daqiao' and password = '123456'");

            List<User> list = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                list.add(user);
            }

            for (User user : list) {
                System.out.println(user);
            }

            rs.close();
            statement.close();
            connection.close();
        }

    }
