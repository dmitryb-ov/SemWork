package com.company.model;

import com.company.role.MyRoleEnum;

public class MyUser {
    private int id;
    private String email;
    private String password;
    private String name;
    private String secondName;
    private String groupId;
    private int points;
    private MyRoleEnum role;

    public MyUser(String email, String password, String name, String secondName, String groupId, int points, MyRoleEnum role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.secondName = secondName;
        this.groupId = groupId;
        this.points = points;
        this.role = role;
    }

    public MyUser(int id, String email, String password, String name, String secondName, String groupId, int points, MyRoleEnum role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.secondName = secondName;
        this.groupId = groupId;
        this.points = points;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public MyRoleEnum getRole() {
        return role;
    }

    public void setRole(MyRoleEnum role) {
        this.role = role;
    }
}
