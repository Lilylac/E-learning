package com.elearning.services;

public interface UserService {
    void register(int userId, String username, String password);

    boolean loginUser(String username, String password);

    boolean checkUsernameAvailable(String username, String password);

    void showAllUsers();

    void showSelectedUser(int IdUser);

    void editSelectedUser(String userName, String password);

    void showOwnedCourse(int id);

    void removeUser(int idUser);


}
