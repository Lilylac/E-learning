package com.elearning.services;

public interface CourseService {
    void showAllCourse(); // ----------- BUAT USER & ADMIN

    void buyCourse(); // ----------- BUAT USER

    void showCourse(int id); // ----------- BUAT USER & ADMIN

    void addCourse(int id, String title, String desc, int price); // ----------- BUAT ADMIN
}
