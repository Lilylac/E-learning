package com.elearning.services;

import com.elearning.module.BaseUser;

import java.util.ArrayList;
import java.util.List;

public class UserAuthServiceImpl implements UserAuthService {
    List<BaseUser> users = new ArrayList<>();
    int userIdHelper = 2024320000;


    @Override
    public void register(int userId, String username, String password) {
        BaseUser user = new BaseUser(userId, username, password);
        users.add(user);
    }

    @Override
    public boolean loginUser(String username, String password) {
        boolean helperLoginUser = false;
        for (BaseUser user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                helperLoginUser = true;
                break;
            }
        }
        return helperLoginUser;
    }

    @Override
    public boolean checkUsernameAvailable(String username, String password) {
        boolean helperRegister = true;
        for (BaseUser user : users) {
            if (user.getUsername().equals(username)) {
                helperRegister = false;
                System.out.println(user.getUsername().equals(username));
                break;
            }
//            else if (username.equalsIgnoreCase("admin")) {
//                helperRegister = false;
//                System.out.println(username.equalsIgnoreCase("admin"));
//                break;
//            }

        }
        return helperRegister;

    }

    @Override
    public void showAllUsers() {
        for (BaseUser user : users) {
            System.out.println("-----------------------------");
            System.out.println("id     : " + user.getUserId());
            System.out.println("Username : " + user.getUsername());
            System.out.println("Password     : " + user.getPassword());
        }
    }


    public int idHandling() {
        return userIdHelper++;
    }
}
