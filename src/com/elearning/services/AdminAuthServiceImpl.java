package com.elearning.services;

import com.elearning.module.BaseAdmin;


import java.util.ArrayList;
import java.util.List;

public class AdminAuthServiceImpl implements AdminAuthService {
List<BaseAdmin> admins = new ArrayList<>();


    @Override
    public boolean loginAdmin(String username, String password) {
        boolean helperLoginAdmin = false;
        for (BaseAdmin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                helperLoginAdmin = true;
                break;
            }
        }

        System.out.println("Jumlah admin: " + admins.size());
        return helperLoginAdmin;
    }

}
