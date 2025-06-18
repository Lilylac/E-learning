package com.elearning.view;

import java.util.Scanner;

public class AdminView {


    void show() {
        Scanner scan = new Scanner(System.in);
        System.out.println("---------------------------ADMIN DASHBOARD-------------------");
        System.out.println("-------------------------------------------------");
        System.out.println("--- 1. Users    2. Admin    3. Course  4. Exit   ");
        System.out.println("-------------------------------------------------");
        int choose = Integer.valueOf(scan.nextLine());
        if (choose == 1) {
            System.out.println("---------------------------Users-------------------");
            System.out.println("-------------------------------------------------");
            System.out.println("--- 1. Show all User");
            System.out.println("--- 2. Edit User");
            System.out.println("--- 3. Remove User");
            System.out.println("--- 4. Create User");
            System.out.println("--- 99. Back");
            System.out.println("-------------------------------------------------");
        } else if (choose == 2) {
            System.out.println("---------------------------Admin-------------------");
            System.out.println("-------------------------------------------------");
            System.out.println("--- 1. Show all Admin");
            System.out.println("--- 2. Edit Admin");
            System.out.println("--- 3. Remove Admin");
            System.out.println("--- 4. Create Admin");
            System.out.println("--- 99. Back");
            System.out.println("-------------------------------------------------");
        } else if (choose == 3) {
            System.out.println("---------------------------Course-------------------");
            System.out.println("-------------------------------------------------");
            System.out.println("--- 1. Show all Courses");
            System.out.println("--- 2. Edit Course");
            System.out.println("--- 3. Remove Course");
            System.out.println("--- 4. Create Course");
            System.out.println("--- 99. Back");
            System.out.println("-------------------------------------------------");
        } else if (choose == 4) {
            return;

        }

    }

}

