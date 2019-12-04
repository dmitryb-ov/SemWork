package com.company.service;

import com.company.dao.MyUserGroupDao;
import com.company.dao.jdbc.JdbcMyUserGroupDaoImpl;
import com.company.db.ConnectionDB;
import com.company.model.Group;
import com.company.model.MyUserGroup;

import java.sql.Connection;

public class MyUserGroupService implements MyUserGroupDao {
    private MyUserGroupDao myUserGroupDao;

    public MyUserGroupService() {
        Connection connection = ConnectionDB.getConnection();
        myUserGroupDao = new JdbcMyUserGroupDaoImpl(connection);
    }

    @Override
    public MyUserGroup get(String id) {
        return myUserGroupDao.get(id);
    }

    @Override
    public void saveUserGroup(String userMail, MyUserGroup group) {
        myUserGroupDao.saveUserGroup(userMail, group);
    }
}
