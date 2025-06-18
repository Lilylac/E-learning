package com.elearning.module;

public class BaseUser {
    private int userid;
    private String username;
    private String password;
    // List<BaseUser> ownedCourse;


    public BaseUser(){};


    public BaseUser(int userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
