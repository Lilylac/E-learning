package com.elearning.view;


import com.elearning.services.AdminServiceImpl;
import com.elearning.services.UserServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainView {
    Scanner scan = new Scanner(System.in);

    UserServiceImpl userService = new UserServiceImpl();
    AdminServiceImpl adminService = new AdminServiceImpl();

    AdminView adminView = new AdminView();
    UserView userView = new UserView();

    public void show() {

        try {
            System.out.println("--------------WELCOME TO ADITYA COURSE-----------");
            System.out.println("-------------------------------------------------");
            System.out.println("--- " + "1. Login    " + "2. Daftar    " + "3. Keluar");
            System.out.println("-------------------------------------------------");
            System.out.print("--- " + "Masukan Pilihan : ");
            int choose = Integer.parseInt(scan.nextLine());
            if (choose == 1) {
                System.out.print("Masukan Username anda: ");
                String username = String.valueOf(scan.nextLine());
                System.out.print("Masukan Password anda: ");
                String password = String.valueOf(scan.nextLine());
                if (adminService.loginAdmin(username, password)) {
                    adminView.showMenu();
                } else if (userService.loginUser(username, password)) {
                    userView.show();
                }
                show();
            } else if (choose == 2) {
                System.out.print("Masukan Username anda: ");
                String username = String.valueOf(scan.nextLine());
                System.out.print("Masukan Password anda: ");
                String password = String.valueOf(scan.nextLine());
                userService.register(userService.idHandling(), username, password);
                System.out.println("Akun anda telah berhasil dibuat");
                show();
            } else if (choose == 3) {
                System.out.println("semoga sukses");

            }

        }
        catch (InputMismatchException e){
            System.out.println("Sout");
        }
    }
}

