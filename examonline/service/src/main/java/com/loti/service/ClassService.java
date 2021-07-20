package com.loti.service;

import com.loti.dao.pojo.Entity.Classe;
import com.loti.dao.pojo.Entity.StudentClass;
import com.loti.dao.pojo.Entity.Trans.TransClass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {
    //添加班级
    void InsertClass(Classe classe);
    //更新所有班上考试的学生考试信息（-1 -> 0）
    void updateExamById(int class_id,int exam_id);
    //添加学生班级关系表
    void InsertStuClass(StudentClass studentClass);
    //略略略
    Classe getClassByTeacher(int teacher_id);
    //通过课程名获取班级列表
    List<Classe> SelectClassByCourse(String course_name);
    //单纯为前端输出数据创建的，获取所有班级详情
    List<TransClass> getAllClassInfo();
    List<TransClass> getClassInfoByCourse(String courseName);
    //获取所有班级名称
    List<String> getAllClassName();
}
