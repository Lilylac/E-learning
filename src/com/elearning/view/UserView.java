package com.elearning.view;

import com.elearning.services.CourseServiceImpl;

import java.util.Scanner;

public class UserView {
    private CourseServiceImpl service;
    Scanner scan = new Scanner(System.in);

    public UserView(CourseServiceImpl service){
        this.service = service;
    }
    public void show(){
        System.out.println("---------------------------USER DASHBOARD-------------------");
        System.out.println("-------------------------------------------------");
        System.out.println("--- 1. Lihat Course    2. Course Saya    3. Edit Profile    3. Exit ");
        System.out.println("-------------------------------------------------");
        System.out.print("Masukan pilihan: ");
        int choose = Integer.valueOf(scan.nextLine());

        switch (choose){
            case 1 -> {
                service.buyCourse();
            }
    }
}
