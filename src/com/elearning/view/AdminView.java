package com.elearning.view;

import com.elearning.services.CourseServiceImpl;
import com.elearning.services.UserServiceImpl;

import java.util.InputMismatchException;
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
        try {
            System.out.println("=========================================================");
            System.out.println("                     ADMIN DASHBOARD                    ");
            System.out.println("=========================================================");
            System.out.println("  1. Users     2. Course     3. Exit");
            System.out.println("=========================================================");
            System.out.print("Masukan Pilihan : ");
            int choose = Integer.valueOf(scan.nextLine());
            switch (choose) {
                case 1 -> {
                    showMenuUser();
                }
                case 2 -> {
                    showMenuCourse();
                }
                case 3 -> {
                    return;
                }
                default -> {
                    System.out.println("=========================================================");
                    System.out.println("                PILIHAN TIDAK TERSEDIA                   ");
                    System.out.println("=========================================================");
                    showMenu();
                }
            }
            showMenu();
        } catch (InputMismatchException e) {
            System.out.println("=========================================================");
            System.out.println("                PILIHAN TIDAK TERSEDIA                   ");
            System.out.println("=========================================================");
            showMenu();
        }

    }

    private void showMenuCourse() {
        try {
            System.out.println("=========================================================");
            System.out.println("                    COURSE SETTINGS                    ");
            System.out.println("=========================================================");
            System.out.println("  1. Tampilkan Semua Course");
            System.out.println("  2. Tambah Course");
            System.out.println("  3. Hapus Course");
            System.out.println("  4. Sunting Course");
            System.out.println(" 99. Kembali");
            System.out.println("=========================================================");
            System.out.print("Masukan Pilihan : ");
            int choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1 -> {
                    courseService.showAllCourse();
                    showMenuCourse();
                }
                case 2 -> {
                    System.out.println("=========================================================");
                    System.out.println("                FORM INPUT KURSUS BARU                   ");
                    System.out.println("=========================================================");
                    System.out.print("Masukan id: ");
                    int id = Integer.parseInt(scan.nextLine());
                    System.out.print("Masukan nama course: ");
                    String nama = String.valueOf(scan.nextLine());
                    System.out.print("Masukan desc course: ");
                    String desc = String.valueOf(scan.nextLine());
                    System.out.print("Masukan harga course: ");
                    int price = Integer.parseInt(scan.nextLine());
                    courseService.addCourse(id, nama, desc, price);
                    showMenuCourse();
                }
                case 3 -> {
                    try {
                        courseService.showAllCourse();
                        System.out.println("=========================================================");
                        System.out.println("                FORM INPUT HAPUS KURSUS                  ");
                        System.out.println("=========================================================");
                        System.out.println("Masukan index kursus yg kamu akan hapus: ");
                        int chooseIndex = Integer.parseInt(scan.nextLine());
                        courseService.removeCourse(chooseIndex);
                        System.out.println("=========================================================");
                        System.out.println("                KURSUS BERHASIL DI HAPUS                 ");
                        System.out.println("=========================================================");
                        showMenuCourse();
                    } catch (InputMismatchException e) {
                        System.out.println("=========================================================");
                        System.out.println("                PILIHAN TIDAK TERSEDIA                   ");
                        System.out.println("=========================================================");
                    }
                }
                case 4 -> {
                    courseService.showAllCourse();
                    System.out.println("=========================================================");
                    System.out.println("                  FORM INPUT EDIT BARU                   ");
                    System.out.println("=========================================================");
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
            System.out.println("=========================================================");
            System.out.println("                HARAP MASUKAN NOMOR ID                   ");
            System.out.println("=========================================================");
            showMenuCourse();
        }
    }


    private void showMenuUser() {
        try {
            System.out.println("=========================================================");
            System.out.println("                      USER SETTINGS                      ");
            System.out.println("=========================================================");
            System.out.println("  1. Tampilkan Semua Pengguna");
            System.out.println("  2. Hapus User");
            System.out.println("  3. Sunting User");
            System.out.println("  4. Kembali");
            System.out.println("=========================================================");

            System.out.print("Masukan Pilihan : ");
            int choose = Integer.parseInt(scan.nextLine());

            switch (choose) {
                case 1 -> {
                    System.out.println("                                                                 ");
                    userService.showAllUsers();
                }
                case 2 -> {
                    userService.showAllUsers();
                    System.out.println("=========================================================");
                    System.out.println("                  FORM INPUT HAPUS USER                   ");
                    System.out.println("=========================================================");
                    System.out.print("Masukan username anda : ");
                    int userId = Integer.valueOf(scan.nextLine());
                    userService.removeUser(userId);
                }
                case 3 -> {
                    System.out.println("=========================================================");
                    System.out.println("        FORM INPUT USERNAME YANG AKAN DI SUNTING         ");
                    System.out.println("=========================================================");
                    System.out.println("Masukan username yang ingin disunting");
                    System.out.println("Masukan username yang ingin disunting");
                    String userId = String.valueOf(scan.nextLine());
                    System.out.println("Masukan user yang ingin dihapus");
                    String password = String.valueOf(scan.nextLine());
                    userService.editSelectedUser(userId, password);
                }
                case 4 -> {
                    return;
                }
                default -> showMenuUser();
            }
            showMenuUser();

        } catch (NumberFormatException e) {
            System.out.println("=========================================================");
            System.out.println("                HARAP MASUKAN NOMOR ID                   ");
            System.out.println("=========================================================");
            showMenuUser();
        }
    }

}

