package com.elearning.services;


public interface CourseService {
    void showAllCourse(); // ----------- BUAT USER & ADMIN

    void addCourse(int id, String title, String desc, int price);

    void removeCourse(int idCourse);

    void editCourse(int id);

    void buyCourse(String username, String password);
}
