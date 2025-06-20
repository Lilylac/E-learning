package com.elearning.services;

import com.elearning.module.BaseCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseServiceImpl implements CourseService {
    Scanner scan = new Scanner(System.in);
    List<BaseCourse> courses = new ArrayList<>();

    @Override
    public void addCourse(int id, String title, String desc, int price) {
        BaseCourse course = new BaseCourse(id, tittle, desc, price);
        courses.add(course);
    }

    /**/
    @Override
    public void showAllCourse() {
        if(courses.isEmpty()){
            System.out.println("Course belum tersedia");
        }
        for (BaseCourse course : courses) {
            System.out.println("Judul: " + course.getTittleCourse());
            System.out.println("Deskripsi: " + course.getDescCourse());
            System.out.println("Harga: " + course.getPriceCourse());
        }
    }


    @Override
    public void buyCourse() {
         try {
            // cari course berdasarkan id
            boolean coursefound = false;

            while (!coursefound) {
                System.out.print("Masukan id course: ");
                int id = scan.nextInt();

                BaseCourse selectcourse = null;

                for (BaseCourse course : courses) {
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
                        if (kembalian > 0) {
                            System.out.println("Kembalian: " + kembalian);
                        }

                    }
                    coursefound = true;
                } else {
                    System.out.println("Course tidak ada silahkan input ulang");
                }
            }
        } catch (InputMismatchException e){
            System.out.println("Input tidak valid. Silahkan masukan angka");
            scan.nextLine();
        }
    }

    @Override
    public void showCourse(int id) {

    }
}
