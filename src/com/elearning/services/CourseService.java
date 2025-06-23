package com.elearning.services;

import com.elearning.module.Course;

import java.util.List;

public interface CourseService {
    void showAllCourse(); // ----------- BUAT USER & ADMIN

    void addCourse(int id, String title, String desc, int price);


//    List<Course> getCourse(int idCourse); REMOVE UNUSED METHOD

    void removeCourse(int idCourse);

    void editCourse(int id);

    void buyCourse(int id);
}
