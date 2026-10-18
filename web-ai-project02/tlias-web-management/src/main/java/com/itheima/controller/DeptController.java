package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.invoker.HttpServiceArgumentResolver;

import java.util.List;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门列表
     */
    // @RequestMapping(value = "/depts" , method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list() {
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping("/depts")
    public Result delete( Integer id) {
        System.out.println("根据部门删除id：" + id);
        deptService.deleteById(id);
        return Result.success();
    }
    /**
     * 新增部门
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        deptService.add(dept);
        System.out.println("新增部门：" + dept);
        return Result.success();
    }
    /**
     * 根据id查询部门
     */
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable Integer id){
        System.out.println("根据id查询部门：" + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    /**
     * 修改部门数据
     */
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门数据"+dept);
        deptService.update(dept);
        return Result.success();

    }
}
