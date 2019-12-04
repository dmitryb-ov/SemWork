package com.company.dao;

import com.company.model.Group;
import com.company.model.MyUserGroup;

public interface MyUserGroupDao {
    MyUserGroup get(String id);
    void saveUserGroup(String userId, MyUserGroup userROle);
}
