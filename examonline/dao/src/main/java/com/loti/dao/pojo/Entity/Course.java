package com.loti.dao.pojo.Entity;

import org.springframework.stereotype.Component;

@Component
public class Course {
    int courseId;
    String courseName;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
