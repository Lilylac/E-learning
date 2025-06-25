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
        try {
            System.out.println("=========================================================");
            System.out.println("                     USER DASHBOARD                     ");
            System.out.println("=========================================================");
            System.out.println("  1. Beli Course   2. Course Saya   3. Edit Profile   4. Exit");
            System.out.println("=========================================================");
            System.out.print("Masukan pilihan: ");
            int choose = Integer.valueOf(scan.nextLine());
            switch (choose) {
                case 1 -> {
                    System.out.println("=========================================================");
                    System.out.println("                    FORM VERIFIKASI USER                 ");
                    System.out.println("=========================================================");
                    System.out.print("Masukan username anda : ");
                    String username = String.valueOf(scan.nextLine());
                    System.out.print("Masukan password anda : ");
                    String password = String.valueOf(scan.nextLine());
                    courseService.buyCourse(username, password);
                    show();
                }
                case 2 -> {
                    System.out.println("=========================================================");
                    System.out.println("                    FORM VERIFIKASI USER                 ");
                    System.out.println("=========================================================");
                    System.out.print("Masukan username anda : ");
                    String username = String.valueOf(scan.nextLine());
                    System.out.print("Masukan password anda : ");
                    String password = String.valueOf(scan.nextLine());
                    userService.showOwnedCourse(username, password);
                    show();
                }
                case 3 -> {
                    System.out.println("=========================================================");
                    System.out.println("                    FORM VERIFIKASI USER                 ");
                    System.out.println("=========================================================");
                    System.out.print("Masukan username anda : ");
                    String username = String.valueOf(scan.nextLine());
                    System.out.print("Masukan password anda : ");
                    String password = String.valueOf(scan.nextLine());
                    userService.editSelectedUser(username, password);
                    show();
                }
                case 4 -> {
                    return;
                }
                default -> {
                    System.out.println("PILIHAN TIDAK TERSEDIA");
                    show();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("=========================================================");
            System.out.println("                PILIHAN TIDAK TERSEDIA                   ");
            System.out.println("=========================================================");
        }
    }
}
