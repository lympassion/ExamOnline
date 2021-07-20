package com.loti.service;

import com.loti.dao.pojo.Entity.Exam;
import com.loti.dao.pojo.Entity.StudentPicture;
import com.loti.dao.pojo.Entity.User.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {
    //通过id查看学生信息
    Student getInfoById(int stu_id);
    //修改学生信息，并存入
    void InsertStu(Student student);
    //查找所有学生
    List<Student> getAllStudent();
    //查找未被分班的学生
    List<Student> getStuUniCourse(String course_name);

    void updateStudent(int studentId,String studentName,int studentGender,String studentPassword,
                       String studentPicture);
    //存入和获取学生监考图像
    void InsertStuPic(StudentPicture studentPicture);
    StudentPicture getStuPic(int stu_id,int exam_id);
}
