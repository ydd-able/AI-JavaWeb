package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author N1357
 * @since 2026/9/23
 */
@Mapper//程序在运行时，会自动为这个接口创建一个实现类对象（动态代理），并注入ioc容器中，
public interface UserMapper {
    //@Select("select * from user")
    public List<User> findAll();
    @Delete("delete from user where id = #{?}")
    public void deleteById(Integer id);
    @Insert("insert into user(username,password,name,age)values(#{username},#{password},#{name},#{age})")
    public void insert(User user);
    @Update("update user set username=#{username},password=#{password},name=#{name},age=#{age} where id=#{id}")
    public void update(User user);
    @Select("select * from user where username=#{username} and password=#{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


}
