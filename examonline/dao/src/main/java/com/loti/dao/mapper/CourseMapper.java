package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> SelectAllCourse();
    Course SelectCourseById(int id);
    void InsertCourse(Course course);
}
