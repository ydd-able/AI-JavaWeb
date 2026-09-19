package com.itheima.service;

import com.itheima.pojo.User;

import java.util.List;

/**
 * @author N1357
 * @since 2026/9/15
 */
public interface UserService {
    /**
     * 查询所有用户信息。
     * @return
     */
    public List<User> findAll();

}
