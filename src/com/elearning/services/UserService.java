package com.elearning.services;

import com.elearning.module.Course;

public interface UserService {
    void register(int userId, String username, String password);

    boolean loginUser(String username, String password);

    boolean checkUsernameAvailable(String username, String password);

    void showAllUsers();

    void editSelectedUser(String userName, String password);

    void showOwnedCourse(String username ,String password);

    void removeUser(int userId);

    void addCourseToUser(String username ,String password, Course course);

}
