package com.elearning.view;

import com.elearning.services.CourseServiceImpl;
import com.elearning.services.UserServiceImpl;

import java.util.Scanner;

public class AdminView {
    private final UserServiceImpl userService;
    private final CourseServiceImpl courseService;

    public AdminView(UserServiceImpl userService , CourseServiceImpl courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    Scanner scan = new Scanner(System.in);

    void showMenu() {
        System.out.println("---------------------------ADMIN DASHBOARD-------------------");
        System.out.println("-------------------------------------------------");
        System.out.println("--- 1. Users  2. Course  4. Exit   ");
        System.out.println("-------------------------------------------------");
        int choose = Integer.valueOf(scan.nextLine());
        switch (choose) {
            case 1 -> showMenuUser();
            case 2 -> showMenuCourse();
//            case 4 -> ;
            case 99 -> {
                return;
            }
        }

    }

    private void showMenuCourse() {
        try {
            System.out.println("1. Tampilkan Semua Course");
            System.out.println("2. Tambah Course");
            System.out.println("3. Hapus Course");
            System.out.println("4. Sunting Course");
            System.out.println("99. Kembali ");
            int choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1 -> courseService.showAllCourse();
                case 2 -> {
                    System.out.print("Masukan id: ");
                    int id = Integer.parseInt(scan.nextLine());
                    System.out.print("Masukan nama course: ");
                    String nama = String.valueOf(scan.nextLine());
                    System.out.print("Masukan desc course: ");
                    String desc = String.valueOf(scan.nextLine());
                    System.out.print("Masukan harga course: ");
                    int price = Integer.parseInt(scan.nextLine());
                    courseService.addCourse(id, nama, desc, price);
                    System.out.println("Course Berhasil ditambahkan");
                    courseService.showAllCourse();
                }
                case 3 -> {
                    courseService.showAllCourse();
                    System.out.println("Masukan index kursus yg kamu akan hapus: ");
                    int chooseIndex = Integer.parseInt(scan.nextLine());
                    courseService.removeCourse(chooseIndex);
                }
                case 4 -> {
                    courseService.showAllCourse();
                    System.out.println("Masukan id kursus yg kamu akan ubah: ");
                    int chooseID = Integer.parseInt(scan.nextLine());
                    courseService.editCourse(chooseID);
                }
                case 99 -> {
                    return;
                }
                default -> showMenuCourse();

            }
            showMenuCourse();
        } catch (NumberFormatException e) {
            System.out.println("Masukkan ID atau Harga Dengan Nomor!!!");
            showMenuCourse();
        }
    }


    private void showMenuUser() {
        System.out.println("1. Tampilakan Semua Pengguna");
        System.out.println("3. Hapus User");
        System.out.println("4. Sunting User");
        System.out.println("99. Kembali");
        int choose = Integer.parseInt(scan.nextLine());
        switch (choose) {
            case 1 -> userService.showAllUsers();
            case 2 -> {
                userService.showAllUsers();
                System.out.println("Masukan user yang ingin dihapus");
                int userId = Integer.valueOf(scan.nextLine());
                userService.removeUser(userId);
            }
            case 3 -> {
                System.out.println("Masukan username yang ingin disunting");
                String userId = String.valueOf(scan.nextLine());
                System.out.println("Masukan user yang ingin dihapus");
                String password = String.valueOf(scan.nextLine());
                userService.editSelectedUser(userId,password);
            }
            case 99 -> {
                return;
            }
        }
        showMenu();
    }

}

