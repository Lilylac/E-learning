package com.elearning.module;

public class BaseCourse {
    private int courseId;
    private String tittleCourse;
    private String descCourse;
    private int priceCourse;

    public BaseCourse(int id, String tittleCourse, String descCourse, int priceCourse){
        this.courseId = id;
        this.tittleCourse = tittleCourse;
        this.descCourse = descCourse;
        this.priceCourse;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getTittleCourse() {
        return tittleCourse;
    }

    public String getDescCourse() {
        return descCourse;
    }

    public int getPriceCourse() {
        return priceCourse;
    }
}
