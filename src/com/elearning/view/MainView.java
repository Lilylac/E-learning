package com.elearning.view;

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
                } else {
                    System.out.println("=========================================================");
                    System.out.println("                  LOGIN ANDA GAGAL                       ");
                    System.out.println("=========================================================");
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
                if (userService.checkUsernameAvailable(username)) {
                    userService.register(userService.idHandling(), username, password);
                    System.out.println("=========================================================");
                    System.out.println("             AKUN TELAH BERHASIL DIBUAT                  ");
                    System.out.println("=========================================================");
                } else {
                    System.out.println("=========================================================");
                    System.out.println("                USERNAME TELAH TERPAKAI                  ");
                    System.out.println("=========================================================");
                }
                show();
            } else if (choose == 3) {
                System.out.println("=========================================================");
                System.out.println("                     SEMOGA SUKSES                       ");
                System.out.println("=========================================================");
            } else {
                System.out.println("=========================================================");
                System.out.println("                PILIHAN TIDAK TERSEDIA                   ");
                System.out.println("=========================================================");
                show();
            }
        } catch (InputMismatchException e) {
            System.out.println("=========================================================");
            System.out.println("                PILIHAN TIDAK TERSEDIA                   ");
            System.out.println("=========================================================");
        }
    }
}

