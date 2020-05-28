package com.spl.user.dao;

import com.spl.user.domain.QueryVo;
import com.spl.user.domain.User;
import com.spl.user.domain.UserDiffProperty;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.IntegerTypeHandler;

import java.util.List;

/**
 * @author pengl
 *
 * 用户持久层接口
 */
@CacheNamespace(blocking=true)//开启二级缓存
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
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 查询一个操作
     * @return
     */
    User findById(Integer id);

    /**
     * 模糊查询
     * @return
     */
    List<User> findByName(String UserName);

    /**
     * 查询用户数
     * @return
     */
    int findUserTotal();

    /**
     * 根据QueryVo查询用户信息
     * @return
     */
    List<User> findByQueryVo(QueryVo vo);

    /**
     * 查询所有操作_实体类属性与数据库字段不对应
     * @return
     */
    List<UserDiffProperty> findDiffPropertyAll();

    /**
     * 查询所有操作_实体类属性与数据库字段不对应
     * @return
     */
    List<UserDiffProperty> findDiffPropertyAll2();

    /**
     * 查询所有操作_实体类属性与数据库字段不对应
     * @return
     */
    List<UserDiffProperty> findUserByCondition(UserDiffProperty user);

    /**
     * 查询多个id
     * @param queryVo
     * @return
     */
    List<UserDiffProperty> findUserByInIds(QueryVo queryVo);

    /**
     * 一对多查询
     * @return
     */
    List<UserDiffProperty> findUserAccount();

    /**
     * 一对多查询-延迟加载
     * @return
     */
    List<User> findUserAccountLazyLoading();

    /**
     * 注解：查询一个操作
     * @return
     */
    @Select(value="select * from user where id = #{id}")
    User findById2(Integer userId);

    /**
     * 注解：多对一开发
     * @return
     */
    @Select(value="select * from user")
    @Results(id = "userMap2", value={
            @Result(id = true , column = "id" , property = "userId"),
            @Result(column = "username" , property = "userName"),
            @Result(column = "birthday" , property = "userBirthday"),
            @Result(column = "sex" , property = "userSex"),
            @Result(column = "address" , property = "userAddress"),
            @Result(property = "account" , column = "id" , many = @Many(select = "com.spl.account.dao.IAccountDao.findAccountBuUid" , fetchType = FetchType.LAZY))
    })
    List<UserDiffProperty> findUserAndAccount();

    /**
     * 查询一个操作
     * @return
     */
    @Select(value="select * from user where id=#{id}")
    User findById3(Integer id);
}
