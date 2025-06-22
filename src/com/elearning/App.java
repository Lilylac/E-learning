package com.elearning;

import com.elearning.module.Admin;
import com.elearning.services.AdminServiceImpl;
import com.elearning.services.CourseService;
import com.elearning.services.CourseServiceImpl;
import com.elearning.services.UserServiceImpl;
import com.elearning.view.AdminView;
import com.elearning.view.MainView;
import com.elearning.view.UserView;

public class App {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        CourseServiceImpl courseService = new CourseServiceImpl();
        AdminServiceImpl adminService = new AdminServiceImpl();

        MainView mainView = new MainView(userService, adminService,courseService);
        mainView.show();
    }
}