package com.elearning.view;

import com.elearning.services.AdminServiceImpl;
import com.elearning.services.UserServiceImpl;

import java.util.Scanner;

public class LoginView {
    Scanner scan = new Scanner(System.in);
    AdminServiceImpl adminService = new AdminServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();
    UserView userView = new UserView();
    AdminView adminView = new AdminView();

    public void showRegister() {
        String password = ""; // <<<----- Helper Agar Password di serviceAuth.isRegisterValid(username,password bisa di inisiasikan
        System.out.println("Masukan Username : ");
        String username = String.valueOf(scan.nextLine());

        if (userService.checkUsernameAvailable(username, password)) {
            System.out.println("Masukan Password : ");
            password = String.valueOf(scan.nextLine());
            userService.register(userService.idHandling(), username, password);
        } else {
            System.out.println("Username telah dipakai "); // atau mengandung kata terlarang
            showRegister();
        }
    }

    public void showLogin() {
        System.out.println("Masukan Username : ");
        String username = String.valueOf(scan.nextLine());
        System.out.println("Masukan Password : ");
        String password = String.valueOf(scan.nextLine());

        if (adminService.loginAdmin(username,password)) {
            adminView.show();
        } else if (userService.loginUser(username, password)) {
            System.out.println("Login Berhasil");
            userView.show();
        } else {
            System.out.println("Login Gagal Masukan Yg benar");
        }
    }
}
