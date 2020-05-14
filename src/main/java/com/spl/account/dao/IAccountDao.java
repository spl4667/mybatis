package com.spl.account.dao;

import com.spl.account.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();
}
