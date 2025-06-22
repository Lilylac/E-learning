package com.elearning.services;

public interface UserService {
    void register(int userId, String username, String password);

    boolean loginUser(String username, String password);

    boolean checkUsernameAvailable(String username, String password);

    void showAllUsers();
}
