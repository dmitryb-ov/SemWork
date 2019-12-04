package com.company.service;

import com.company.dao.GroupDao;
import com.company.dao.jdbc.JdbcGroupDaoImpl;
import com.company.db.ConnectionDB;
import com.company.model.Group;

import java.sql.Connection;
import java.util.List;

public class GroupService implements GroupDao {
    private GroupDao gDao;

    public GroupService() {
        Connection connection = ConnectionDB.getConnection();
        gDao = new JdbcGroupDaoImpl(connection);
    }

    @Override
    public Group get(int id) {
        return gDao.get(id);
    }

    @Override
    public Group get(String groupNumber) {
        return gDao.get(groupNumber);
    }

    @Override
    public void add(Group group) {
        gDao.add(group);
    }

    @Override
    public void delete(String groupNumber) {
        gDao.delete(groupNumber);
    }

    @Override
    public List<Group> getAll() {
        return gDao.getAll();
    }
}
