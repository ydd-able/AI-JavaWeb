package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
@Mapper
public interface DeptMapper {
    //手动结果映射
    @Results({
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select * from dept")
    public List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
    public void deleteById(Integer id);

    @Insert("Insert into dept( name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    public void insert(Dept dept);
    /**
     * 根据id查询部门数据
     */
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
     Dept getById(Integer id);

    @Update("update dept set name = #{name} , update_time = #{updateTime} where id = #{id} ")
    void update(Dept dept);






}
