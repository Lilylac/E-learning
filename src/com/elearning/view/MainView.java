package com.elearning.view;


import com.elearning.module.Course;
import com.elearning.module.User;
import com.elearning.services.AdminServiceImpl;
import com.elearning.services.CourseServiceImpl;
import com.elearning.services.UserServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainView {
    private final UserServiceImpl userService;
    private final AdminServiceImpl adminService;
    private final CourseServiceImpl courseService;
    Scanner scan = new Scanner(System.in);

    public MainView(UserServiceImpl userService, AdminServiceImpl adminService, CourseServiceImpl courseService) {
        this.userService = userService;
        this.adminService = adminService;
        this.courseService = courseService;
    }


    public void show() {
        try {
            System.out.println("=========================================================");
            System.out.println("                 WELCOME TO ADITYA COURSE                 ");
            System.out.println("=========================================================");
            System.out.println("  1. Login       2. Daftar       3. Keluar");
            System.out.println("=========================================================");
            System.out.print("Masukan Pilihan : ");
            int choose = Integer.parseInt(scan.nextLine());

            if(choose < 1 || choose > 3){
                System.out.println("Pilihan tidak ada");
                show();
            }
            
            if (choose == 1) {
                System.out.println("=========================================================");
                System.out.println("                     FORM INPUT LOGIN                    ");
                System.out.println("=========================================================");
                System.out.print("Masukan Username anda: ");
                String username = String.valueOf(scan.nextLine());
                System.out.print("Masukan Password anda: ");
                String password = String.valueOf(scan.nextLine());
                if (adminService.loginAdmin(username, password)) {
                    AdminView adminView = new AdminView(userService, courseService);
                    adminView.showMenu();
                } else if (userService.loginUser(username, password)) {
                    UserView userView = new UserView(userService, courseService);
                    userView.show();
                }
                show();
            } else if (choose == 2) {
                System.out.println("=========================================================");
                System.out.println("                  FORM INPUT REGISTER                    ");
                System.out.println("=========================================================");
                System.out.print("Masukan Username anda: ");
                String username = String.valueOf(scan.nextLine());
                System.out.print("Masukan Password anda: ");
                String password = String.valueOf(scan.nextLine());
                if(userService.checkUsernameAvailable(username,password)){
                    userService.register(userService.idHandling(), username, password);
                    System.out.println("Akun anda telah berhasil dibuat");
                } else {
                    System.out.println("Username telah terpakai");
                }

                show();
            } else if (choose == 3) {
                System.out.println("semoga sukses");

            }

        } catch (InputMismatchException e) {
            System.out.println("Sout");
        }
    }
}

