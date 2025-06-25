package com.elearning.services;

import com.elearning.module.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CourseServiceImpl implements CourseService {
    Scanner scan = new Scanner(System.in);
    List<Course> courses = new ArrayList<>();
    private final UserServiceImpl userService;

    public CourseServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }


    @Override
    public void showAllCourse() {
        if (courses.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("                   COURSE BELUM TERSEDIA                 ");
            System.out.println("=========================================================");

        }
        System.out.println("=========================================================");
        System.out.println("                       DATA COURSE                       ");
        System.out.println("=========================================================");
        for (Course course : courses) {
            System.out.println("ID       : " + course.getCourseId());
            System.out.println("Judul    : " + course.getTittleCourse());
            System.out.println("Deskripsi: " + course.getDescCourse());
            System.out.println("Harga    : Rp " + course.getPriceCourse());
            System.out.println("=========================================================");
        }
    }



    @Override
    public void addCourse(int idCourse, String title, String desc, int price) {
        for (Course course : courses) {
            if (idCourse == course.getCourseId()) {
                System.out.println("=========================================================");
                System.out.println("            HARAP MENGGUNAKAN ID YANG BERBEDA            ");
                System.out.println("=========================================================");
                return;
            }
        }
        Course course = new Course(idCourse, title, desc, price);
        courses.add(course);
    }

    @Override
    public void removeCourse(int idCourse) {
        courses.removeIf(course -> idCourse == course.getCourseId());
        boolean checkTrue = courses.removeIf(course -> idCourse == course.getCourseId());
        if (!checkTrue) {
            System.out.println("Course Tidak Terdaftar");
            return;
        }
        System.out.println("Kursus berhasil di hapus");
    }


    public void editCourse(int idCourse) {
        if (courses.isEmpty()) {
            System.out.println("Belum ada kursus yang terdaftar");
        }
        for (Course course : courses) {
            if (idCourse == course.getCourseId()) {
                System.out.println("=========================================================");
                System.out.println("                       DATA COURSE                       ");
                System.out.println("=========================================================");
                System.out.println("1. ID       : " + course.getCourseId());
                System.out.println("2. Judul    : " + course.getTittleCourse());
                System.out.println("3. Deskripsi: " + course.getDescCourse());
                System.out.println("4. Harga    : Rp " + course.getPriceCourse());
                System.out.println("=========================================================");
                System.out.print("Informasi apa yang akan kamu ubah?: ");
                int helperEditCourse = Integer.parseInt(scan.nextLine());
                System.out.println("=========================================================");
                switch (helperEditCourse) {
                    case 1 -> {
                        System.out.println("=========================================================");
                        System.out.println("                FORM INPUT ID KURSUS BARU                ");
                        System.out.println("=========================================================");
                        System.out.print("Masukan id kursus baru : ");
                        int newIdCourse = Integer.parseInt(scan.nextLine());
                        course.setCourseId(newIdCourse);
                    }
                    case 2 -> {
                        System.out.println("=========================================================");
                        System.out.println("              FORM INPUT JUDUL KURSUS BARU               ");
                        System.out.println("=========================================================");
                        System.out.print("Masukan judul kursus baru: ");
                        String newTitleCourse = String.valueOf(scan.nextLine());
                        course.setTittleCourse(newTitleCourse);
                        System.out.println("=========================================================");
                        System.out.println("               JUDUL COURSE BERHASIL DIUBAH              ");
                        System.out.println("=========================================================");
                    }
                    case 3 -> {
                        System.out.println("=========================================================");
                        System.out.println("             FORM INPUT DESKRIPSI KURSUS BARU            ");
                        System.out.println("=========================================================");
                        System.out.print("Masukan deskripsi kursus baru: ");
                        String newDecs = String.valueOf(scan.nextLine());
                        course.setDescCourse(newDecs);
                        System.out.println("=========================================================");
                        System.out.println("            DEKSRIPSI COURSE BERHASIL DIUBAH             ");
                        System.out.println("=========================================================");
                    }
                    case 4 -> {
                        System.out.println("=========================================================");
                        System.out.println("             FORM INPUT HARGA KURSUS BARU                ");
                        System.out.println("=========================================================");
                        System.out.print("Masukan harga kursus baru: ");
                        int newPrice = Integer.parseInt(scan.nextLine());
                        course.setPriceCourse(newPrice);
                        System.out.println("=========================================================");
                        System.out.println("            HARGA COURSE BERHASIL DIUBAH             ");
                        System.out.println("=========================================================");
                    }
                    default -> {
                        System.out.println("Pilihan tidak ada");
                    }
                }
            }
        }
    }



    public void buyCourse(String username, String password){
        try {
            // cari course berdasarkan id
            boolean coursefound = false;

            if (courses.isEmpty()) {
                System.out.println("=========================================================");
                System.out.println("                   COURSE BELUM TERSEDIA                 ");
                System.out.println("=========================================================");
            } else {
                while (!coursefound) {
                    if (courses.isEmpty()) {
                        System.out.println("=========================================================");
                        System.out.println("                   COURSE BELUM TERSEDIA                 ");
                        System.out.println("=========================================================");
                        return;
                    } else {
                        showAllCourse();
                        System.out.println("=========================================================");
                        System.out.println("               FORM INPUT MEMBELI KURSUS                 ");
                        System.out.println("=========================================================");
                        System.out.print("Masukan id course: ");
                        int id = scan.nextInt();
                        Course selectcourse = null;
                        for (Course course : courses) {
                            if (id == course.getCourseId()) {
                                selectcourse = course;
                            }
                        }
                        // jika course ditemukan tampilkan informasi detailnya
                        if (selectcourse != null) {
                            System.out.println("=========================================================");
                            System.out.println("                       DATA COURSE                       ");
                            System.out.println("=========================================================");
                            System.out.println("ID       : " + selectcourse.getCourseId());
                            System.out.println("Judul    : " + selectcourse.getTittleCourse());
                            System.out.println("Deskripsi: " + selectcourse.getDescCourse());
                            System.out.println("Harga    : Rp " + selectcourse.getPriceCourse());
                            System.out.println("=========================================================");
                            System.out.print("Masukan pembayaran sesuai nominal: ");
                            int bayar = scan.nextInt();

                            int harga = selectcourse.getPriceCourse();

                            if (bayar < harga) {
                                System.out.println("Pembayaran tidak cukup. total course: " + harga);
                            } else {
                                int kembalian = bayar - harga;
                                System.out.println("Pembayaran berhasil");
                                userService.addCourseToUser(username, password, selectcourse);
                                System.out.println("Course telah ditambahkan ke dalam akun anda");

                                if (kembalian > 0) {
                                    System.out.println("Kembalian: " + kembalian);
                                }
                            }
                            coursefound = true;
                        } else {
                            System.out.println("=========================================================");
                            System.out.println("                PILIHAN TIDAK TERSEDIA                   ");
                            System.out.println("=========================================================");
                        }

                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silahkan masukan angka");
            scan.nextLine();
        }
    }
}

