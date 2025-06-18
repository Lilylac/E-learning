package com.elearning.services;

public interface UserAuthService {
    void register(int userId, String username, String password);

    boolean loginUser(String username, String password);

    boolean checkUsernameAvailable(String username, String password);

    void showAllUsers();
}
