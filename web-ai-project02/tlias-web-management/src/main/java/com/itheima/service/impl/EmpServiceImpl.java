package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * 原始分页查询
     * @param page 页码
     * @param pageSize 每页展示的记录数
     * @return
     */
    //    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        //调用mapper接口，查询总记录数
//        Long count = empMapper.count();
//        //调用mapper接口，查询结果列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> list = empMapper.list(start, pageSize);
//        //返回结果。
//        return new PageResult<Emp>(count,list);
//
    //   }

    /**
     * 基于pagehelper来实现分页查询。
     * @param page 页码
     * @param pageSize 每页展示的记录数
     * @return
     */
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1.设置分页参数。
        PageHelper.startPage(page,pageSize);
        //2.执行查询
        empMapper.list();
        //3.返回查询结果
        return new PageResult<Emp>()

    }
}
