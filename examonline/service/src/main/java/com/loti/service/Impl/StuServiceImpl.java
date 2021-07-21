package com.loti.service.Impl;

import com.loti.dao.mapper.StuMapper;
import com.loti.dao.mapper.StuPicMapper;
import com.loti.dao.pojo.Entity.Exam;
import com.loti.dao.pojo.Entity.StudentPicture;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class StuServiceImpl implements StudentService {

    @Autowired(required = false)
    private StuMapper stuMapper;
    @Autowired(required = false)
    private StuPicMapper stuPicMapper;

    @Override
    public Student getInfoById(int stu_id) {
        return stuMapper.selectById(stu_id);
    }

    @Override
    public void InsertStu(Student student) {
        stuMapper.InsertStudent(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return stuMapper.getAllStudent();
    }

    @Override
    public List<Student> getStuUniCourse(String course_name) {
        return stuMapper.selectStuUniCourse(course_name);
    }

    @Override
    public void updateStudent(int studentId, String studentName, int studentGender, String studentPassword, String studentPicture) {
        Student student = stuMapper.selectById(studentId);
        student.setStudentName(studentName);
        student.setStudentGender(studentGender);
        student.setStudentPassword(studentPassword);
        student.setStudentPicture(studentPicture);
        stuMapper.updateStuInfo(student);
    }

    @Override
    public void InsertStuPic(StudentPicture studentPicture) {
        stuPicMapper.InsertStuPic(studentPicture);
    }

    @Override
    public StudentPicture getStuPic(int stu_id, int exam_id) {
        return stuPicMapper.SelectStuPic(stu_id,exam_id);
    }

}
