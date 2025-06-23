package com.elearning.services;

import com.elearning.module.Course;

public interface UserService {
    void register(int userId, String username, String password);

    boolean loginUser(String username, String password);

    boolean checkUsernameAvailable(String username);

    void showAllUsers();

    void editSelectedUser(String userName, String password);

    void showOwnedCourse(String username);

    void removeUser(int idUser);

    void addCourseToUser(int idUser, Course course);

}
