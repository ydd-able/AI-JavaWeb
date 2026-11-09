package com.itheima.service;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
public interface DeptService {
    List<Dept> findAll();

    /**
     *根据ID删除部门
     */
    void deleteById(Integer id);
    /**
     * 添加部门
     */
    void add(Dept dept);
    /**
     * 根据ID查询部门
     */
    Dept getById(Integer id);

    void update(Dept dept);



}
