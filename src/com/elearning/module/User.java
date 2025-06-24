package com.elearning.module;


import java.util.ArrayList;
import java.util.List;

public class User {
    private int userid;
    private String username;
    private String password;
    private List<Course> ownedCourse = new ArrayList<>();

    public User(){}


    public User(int userid, String username, String password) {
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

    public List<Course> getOwnedCourse() {
        return ownedCourse;
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

    public void setOwnedCourse(Course course){
        ownedCourse.add(course);
    }
}
