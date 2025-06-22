package com.elearning.services;

import com.elearning.module.Admin;

public class AdminServiceImpl implements AdminService {

    @Override
    public boolean loginAdmin(String username, String password) {
        Admin admin = new Admin(0, "admin", "admin");
        return admin.getUsername().equals(username) && admin.getPassword().equals(password);
    }
}

