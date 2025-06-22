package com.elearning.module;

public class Course {
    private int courseId;
    private String tittleCourse;
    private String descCourse;
    private int priceCourse;

    public Course(int id, String tittleCourse, String descCourse, int priceCourse){
        this.courseId = id;
        this.tittleCourse = tittleCourse;
        this.descCourse = descCourse;
        this.priceCourse = priceCourse;
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

    public void setTittleCourse(String newTitleCourse) {
    }

    public void setDescCourse(String newDecs) {
    }

    public void setPriceCourse(int newPrice) {
    }

    public void setCourseId(int newIdCourse) {
    }
}
