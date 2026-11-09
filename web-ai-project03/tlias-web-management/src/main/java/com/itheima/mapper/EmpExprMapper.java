package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */

/**
 * 员工经历的注解
 */
@Mapper
public interface EmpExprMapper {


    void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> empIds);
}
