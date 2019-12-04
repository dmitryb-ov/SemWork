package com.company.service;

import com.company.dao.MyUserDao;
import com.company.dao.jdbc.JdbcMyUserDaoImpl;
import com.company.db.ConnectionDB;
import com.company.model.MyUser;

import java.sql.Connection;
import java.util.List;

public class MyUserService implements MyUserDao {
    private MyUserDao uDao;

    public MyUserService() {
        Connection connection = ConnectionDB.getConnection();
        uDao = new JdbcMyUserDaoImpl(connection);
    }

    @Override
    public MyUser get(String email) {
        return uDao.get(email);
    }

    @Override
    public List<MyUser> getAll() {
        return uDao.getAll();
    }

    @Override
    public void create(MyUser item) {
        uDao.create(item);
    }

    @Override
    public void update(String email, MyUser userItem) {
        uDao.update(email,userItem);
    }

    @Override
    public void delete(String email) {
        uDao.delete(email);
    }
}
