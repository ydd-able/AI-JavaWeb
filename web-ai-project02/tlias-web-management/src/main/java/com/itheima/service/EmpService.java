package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
public interface EmpService {
    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);
    /**
     * 新增员工
     */
    void save(Emp emp);


    void delete(List<Integer> ids);


    Emp getInfo(Integer id);

    void update(Emp emp);
}
