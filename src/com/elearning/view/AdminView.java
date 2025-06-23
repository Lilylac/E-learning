package com.elearning.view;

import com.elearning.services.CourseServiceImpl;
import com.elearning.services.UserServiceImpl;

import java.util.Scanner;

public class AdminView {
    private final UserServiceImpl userService;
    private final CourseServiceImpl courseService;

    public AdminView(UserServiceImpl userService, CourseServiceImpl courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    Scanner scan = new Scanner(System.in);

    void showMenu() {
        System.out.println("                         ADMIN DASHBOARD                        ");
        System.out.println("                                                                ");
        System.out.println("   1. Users     2. Course     3. Exit                            ");
        System.out.println("                                                                ");
        System.out.print("   Masukan Pilihan : ");
        int choose = Integer.valueOf(scan.nextLine());
        switch (choose) {
            case 1 -> {
                showMenuUser();
                showMenu();
            }
            case 2 -> {
                showMenuCourse();
                showMenu();
            }
            case 3 -> {
                return;
            }
            default -> showMenu();
        }
    }

    private void showMenuCourse() {
        try {
            System.out.println("                         COURSE SETTING                          ");
            System.out.println("                                                                 ");
            System.out.println("1. Tampilkan Semua Course");
            System.out.println("2. Tambah Course");
            System.out.println("3. Hapus Course");
            System.out.println("4. Sunting Course");
            System.out.println("99. Kembali");
            System.out.println("                                                                ");
            System.out.print("   Masukan Pilihan : ");

            int choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1 -> {
                    courseService.showAllCourse();
                    showMenuCourse();
                }
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
                    showMenuCourse();
                }
                case 3 -> {
                    courseService.showAllCourse();
                    System.out.println("Masukan index kursus yg kamu akan hapus: ");
                    int chooseIndex = Integer.parseInt(scan.nextLine());
                    courseService.removeCourse(chooseIndex);
                    showMenuCourse();
                }
                case 4 -> {
                    courseService.showAllCourse();
                    System.out.println("Masukan id kursus yg kamu akan ubah: ");
                    int chooseID = Integer.parseInt(scan.nextLine());
                    courseService.editCourse(chooseID);
                    showMenuCourse();
                }
                case 99 -> {
                    return;
                }
                default -> showMenuCourse();

            }
        } catch (NumberFormatException e) {
            System.out.println("Masukkan ID atau Harga Dengan Nomor!!!");
            showMenuCourse();
        }
    }


    private void showMenuUser() {
        try {
            System.out.println("                         USER SETTING                           ");
            System.out.println("                                                                 ");
            System.out.println("1. Tampilkan Semua Pengguna");
            System.out.println("2. Hapus User");
            System.out.println("3. Sunting User");
            System.out.println("4. Kembali");
            System.out.println("                                                                ");
            System.out.print("   Masukan Pilihan : ");
            int choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1 -> {
                    userService.showAllUsers();
                    showMenuUser();
                }
                case 2 -> {
                    userService.showAllUsers();
                    System.out.println("Masukan user yang ingin dihapus");
                    int userId = Integer.valueOf(scan.nextLine());
                    userService.removeUser(userId);
                    showMenuUser();
                }
                case 3 -> {
                    System.out.println("Masukan username yang ingin disunting");
                    String userId = String.valueOf(scan.nextLine());
                    System.out.println("Masukan user yang ingin dihapus");
                    String password = String.valueOf(scan.nextLine());
                    userService.editSelectedUser(userId, password);
                    showMenuUser();
                }
                case 4 -> {
                    return;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Masukan input dengan benar");
            showMenuUser();
        }
    }

}

