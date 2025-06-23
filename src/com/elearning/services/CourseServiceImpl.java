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
    public void addCourse(int id, String title, String desc, int price) {
        Course course = new Course(id, title, desc, price);
        courses.add(course);
    }


    @Override
    public void removeCourse(int idCourse) {
        courses.removeIf(course -> idCourse == course.getCourseId());
        System.out.println("Kursus berhasil di hapus");
    }


    @Override
    public void editCourse(int idCourse) {
        if (courses.isEmpty()) {
            System.out.println("Belum ada kursus yang terdaftar");

        }
        for (Course course : courses) {
            if (idCourse == course.getCourseId()) {
                System.out.println("1. Id kursus : " + course.getCourseId());
                System.out.println("2. Nama kursus : " + course.getTittleCourse());
                System.out.println("3. Deskripsi Kursus : " + course.getDescCourse());
                System.out.println("4. Harga Kursus : " + course.getPriceCourse());

                System.out.println("Informasi apa yang akan kamu ubah?");
                int helperEditCourse = Integer.parseInt(scan.nextLine());
                switch (helperEditCourse) {
                    case 1 -> {
                        System.out.println("Masukan id kursus baru");
                        int newIdCourse = Integer.parseInt(scan.nextLine());
                        course.setCourseId(newIdCourse);
                    }
                    case 2 -> {
                        System.out.println("Masukan judul kursus baru");
                        String newTitleCourse = String.valueOf(scan.nextLine());
                        course.setTittleCourse(newTitleCourse);
                    }
                    case 3 -> {
                        System.out.println("Masukan deskripsi kursus baru");
                        String newDecs = String.valueOf(scan.nextLine());
                        course.setDescCourse(newDecs);
                    }
                    case 4 -> {
                        System.out.println("Masukan harga kursus baru");
                        int newPrice = Integer.parseInt(scan.nextLine());
                        course.setPriceCourse(newPrice);
                    }
                }
            }
        }
    }

    /**/
    @Override
    public void showAllCourse() {
        if (courses.isEmpty()) {
            System.out.println("Course belum tersedia");
        }
        for (Course course : courses) {
            System.out.println("Kursus id: " + course.getCourseId());
            System.out.println("Judul: " + course.getTittleCourse());
            System.out.println("Deskripsi: " + course.getDescCourse());
            System.out.println("Harga: " + course.getPriceCourse());
        }
    }


    @Override
    public void buyCourse(int idUser) {
        try {
            // cari course berdasarkan id
            boolean coursefound = false;

            while (!coursefound) {
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
                    System.out.println("Judul: " + selectcourse.getTittleCourse());
                    System.out.println("Deskripsi: " + selectcourse.getDescCourse());
                    System.out.println("Harga: " + selectcourse.getPriceCourse());

                    System.out.print("Masukan pembayaran sesuai nominal: ");
                    int bayar = scan.nextInt();

                    int harga = selectcourse.getPriceCourse();

                    if (bayar < harga) {
                        System.out.println("Pembayaran tidak cukup. total course: " + harga);
                    } else {
                        int kembalian = bayar - harga;
                        System.out.println("Pembayaran berhasil");
                        userService.addCourseToUser(idUser, selectcourse);
                        System.out.println("Course telah ditambahkan ke dalam akun anda");

                        if (kembalian > 0) {
                            System.out.println("Kembalian: " + kembalian);
                        }
                    }
                    coursefound = true;
                } else {
                    System.out.println("Course tidak ada silahkan input ulang");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silahkan masukan angka");
            scan.nextLine();
        }
    }
}
