package com.elearning.services;

import com.elearning.module.Course;

public interface CourseService {
    void showAllCourse(); // ----------- BUAT USER & ADMIN

    void showCourse(int id); // ----------- BUAT USER & ADMIN

    void addCourse(int id, String title, String desc, int price); // ----------- BUAT ADMIN
    Course getCourse(int idCourse);

    void removeCourse(int idCourse);

    void editCourse(int id);
}
