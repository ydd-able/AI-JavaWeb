package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
public interface EmpService {
    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页展示的记录数
     * @return
     */
    PageResult<Emp> page(Integer page, Integer pageSize);
}
