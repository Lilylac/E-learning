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
                System.out.println("Masukan Id Anda : ");
                int idUser = Integer.valueOf(scan.nextLine());
                courseService.buyCourse(idUser);
                show();
            }
            case 2 -> {
                System.out.println("Masukan Id Anda : ");
                int idUser = Integer.valueOf(scan.nextLine());
                userService.showOwnedCourse(idUser);
                show();

            }
            case 3 -> {
                System.out.println("Masukan username: ");
                String username = String.valueOf(scan.nextLine());
                System.out.println("Masukan password: ");
                String password = String.valueOf(scan.nextLine());
                userService.editSelectedUser(username, password);
                show();
            }
            case 99 -> {
                return;
            }
        }
    }
}
