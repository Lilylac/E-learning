package com.elearning.services;


import com.elearning.module.BaseCourse;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    List<BaseCourse> courses = new ArrayList<>();


    /**/
    @Override
    public void showAllCourse() {
        for (BaseCourse course : courses) {
            System.out.println("Judul: " + course.getTittleCourse());
            System.out.println("Deskripsi: " + course.getDescCourse());
            System.out.println("Harga: " + course.getPriceCourse());
        }
    }


    @Override
    public void buyCourse() {


    }

    @Override
    public void showCourse(int id) {

    }

    @Override
    public void addCourse() {

    }
}
