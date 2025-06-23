package com.elearning;

import com.elearning.services.AdminServiceImpl;
import com.elearning.services.CourseServiceImpl;
import com.elearning.services.UserServiceImpl;
import com.elearning.view.MainView;


public class App {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        CourseServiceImpl courseService = new CourseServiceImpl(userService);
        AdminServiceImpl adminService = new AdminServiceImpl();

        MainView mainView = new MainView(userService, adminService,courseService);
        mainView.show();
    }
}