package com.company.model;

public class Group {
    private int id;
    private String groupNumber;

    public Group(int id, String groupNumber) {
        this.id = id;
        this.groupNumber = groupNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
}
