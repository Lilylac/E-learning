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

            if (choose < 1 || choose > 4) {
                System.out.println("Pilihan tidak ada");
                show();
            }

            switch (choose) {
                case 1 -> {
                    System.out.println("=========================================================");
                    System.out.println("                     FORM BELI COURSE                    ");
                    System.out.println("=========================================================");
                    courseService.showAllCourse();
                    System.out.println("Masukan Id Anda : ");
                    int idUser = Integer.valueOf(scan.nextLine());
                    courseService.buyCourse(idUser);
                    show();
                }
                case 2 -> {
                    System.out.println("=========================================================");
                    System.out.println("                    FORM VERIFIKASI USER                 ");
                    System.out.println("=========================================================");
                    System.out.println("Masukan ID Anda : ");
                    String username = String.valueOf(scan.nextLine());
                    String password = String.valueOf(scan.nextLine());
                    userService.showOwnedCourse(username, password);
                    show();

                }
                case 3 -> {
                    System.out.println("                                                                 ");
                    System.out.println("Masukan username: ");
                    String username = String.valueOf(scan.nextLine());
                    System.out.println("Masukan password: ");
                    String password = String.valueOf(scan.nextLine());
                    userService.editSelectedUser(username, password);
                    show();
                }
                case 4 -> {
                    return;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Silahkan masukan angka");
        }
    }
}
