package com.spl.account.dao;

import com.spl.account.domain.Account;
import com.spl.account.domain.AccountUser;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户信息及用户信息
     * @return
     */
    List<AccountUser> findAccountUser();

    /**
     * 查询所有账户信息及用户信息
     * @return
     */
    List<Account> findAccountUser2();

    /**
     * 延迟加载
     * @return
     */
    List<Account> findAccountUserLadyLoading();

    List<Account> findAccountBuUid(Integer uid);

    /**
     * 注解：一对一查询
     * @return
     */
    @Select(value = "select * from account")
    @Results(id = "accountMap", value={
            @Result(id = true , column = "id" , property = "id"),
            @Result(column = "uid" , property = "uid"),
            @Result(column = "money" , property = "money"),
            @Result(property = "user" , column = "uid" , one = @One(select = "com.spl.user.dao.IUserDao.findById" , fetchType = FetchType.EAGER))
    })
    List<Account> findAccountAndUser();
}
