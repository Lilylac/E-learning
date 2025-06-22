package com.elearning.view;

import com.elearning.services.CourseServiceImpl;
import com.elearning.services.UserServiceImpl;

import java.util.Scanner;

public class UserView {
    Scanner scan = new Scanner(System.in);

    private final UserServiceImpl userService;
    private final CourseServiceImpl courseService;

    public UserView(UserServiceImpl userService, CourseServiceImpl courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }


    public void show() {
        System.out.println("---------------------------USER DASHBOARD-------------------");
        System.out.println("-------------------------------------------------");
        System.out.println("--- 1. Beli Course    2. Course Saya    3. Edit Profile    99. Exit ");
        System.out.println("-------------------------------------------------");
        System.out.print("Masukan pilihan: ");
        int choose = Integer.valueOf(scan.nextLine());

        switch (choose) {
            case 1 -> {
                courseService.showAllCourse();
            }
            case 2 -> {
                System.out.println("Masukan Id Mu : ");
                int idUser = Integer.valueOf(scan.nextLine());
                userService.showOwnedCourse(idUser);

            }
            case 3 -> {
//                userService.editSelectedUser();
            }
            case 99 -> {
                return;
            }
        }
    }
}
