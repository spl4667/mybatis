package com.spl.user.dao;

import com.spl.user.domain.User;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 查询所有操作-注解方式
     * @return
     */
    @Select("select * from user")
    List<User> findAllAnnotation();

    /**
     * 保存
     * @param user
     */
    void saveUser(User user);
}
