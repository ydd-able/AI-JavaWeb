package com.itheima.dao;

import java.util.List;

/**
 * @author N1357
 * @since 2026/9/15
 */
public interface UserDao {
    //加载用户数据。
    public List<String> findAll();
}
