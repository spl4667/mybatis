package com.spl.user.dao;

import com.spl.user.domain.User;

import java.util.List;

/**
 * @author pengl
 *
 * 用户持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();
}
