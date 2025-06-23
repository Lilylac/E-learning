package com.elearning.services;

import com.elearning.module.Course;

import java.util.List;

public interface CourseService {
    void showAllCourse(); // ----------- BUAT USER & ADMIN

    void addCourse(int id, String title, String desc, int price);
    // ----------- BUAT ADMIN
    List<Course> getCourse(int idCourse);

    void removeCourse(int idCourse);

    void editCourse(int id);

    void buyCourse(int id);
}
