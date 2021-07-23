package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.User.MyUser;
import com.loti.dao.pojo.Entity.User.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StuMapper {
    List<Student> getAllStudent();
    void InsertStudent(Student student);
    Student selectById(int id);
    Student selectByIdAndPass(MyUser user);
    List<Student> selectStuUniCourse(String courseName);
    List<Student> selectStuByClass(int class_id);
    void updateStuInfo(Student student);
    void setStuClass(@Param("stuId") int stuId,@Param("stuClass") String stuClass);
}
