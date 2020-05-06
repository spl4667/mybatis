package com.spl.user.dao.impl;

import com.spl.user.dao.IUserDao;
import com.spl.user.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory)
    {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<User> findAll() {
        this.sqlSession = sqlSessionFactory.openSession();
        List<User> userList = this.sqlSession.selectList("com.spl.user.dao.IUserDao.findAll");
        this.sqlSession.close();
        return userList;
    }

    public List<User> findAllAnnotation() {
        return null;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer id) {

    }
}
