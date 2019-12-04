package com.company.model;

public class MyUserGroup {
    private String gId;
    private String userMail;

    public MyUserGroup(String mail, String id) {
        this.gId = id;
        this.userMail = mail;
    }

    public String getId() {
        return userMail;
    }

    public String getRole() {
        return gId;
    }
}
