package com.itheima.service;


import com.itheima.pojo.JobOption;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */

public interface ReportService {

    /**
     * 统计员工职位人数
     * @return
     */
    JobOption getEmpJobData();
}
