package com.company.dao;

import com.company.model.MyUser;

import java.util.List;

public interface MyUserDao {
    MyUser get(String email);
    List<MyUser> getAll();
    void create(MyUser item);
    void update(String email, MyUser userItem);
    void delete(String email);
}
