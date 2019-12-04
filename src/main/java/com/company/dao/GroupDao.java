package com.company.dao;

import com.company.model.Group;

import java.util.List;

public interface GroupDao {
    Group get(int id);

    Group get(String groupNumber);

    void add(Group group);

    void delete(String groupNumber);

    List<Group> getAll();
}
