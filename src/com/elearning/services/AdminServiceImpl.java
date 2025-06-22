package com.elearning.services;

import com.elearning.module.Admin;


import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
List<Admin> admins = new ArrayList<>();


    @Override
    public boolean loginAdmin(String username, String password) {
        boolean helperLoginAdmin = false;
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                helperLoginAdmin = true;
                break;
            }
        }

        System.out.println("Jumlah admin: " + admins.size());
        return helperLoginAdmin;
    }

}
