package com.elearning.module;

public class Admin {
    private int userId;
    private String username;
    private String password;

    public Admin(){}

    public Admin(int userid, String username, String password) {
        this.userId = userid;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
