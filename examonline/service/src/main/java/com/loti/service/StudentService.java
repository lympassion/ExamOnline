package com.loti.service;

import com.loti.dao.pojo.Entity.Exam;
import com.loti.dao.pojo.Entity.User.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {
    //通过id查看学生信息
    Student getInfoById(String id);
    //修改学生信息，并存入
    void InsertStu(Student student);
    //查看可参加考试 by ?
    List<Exam> getExamIn();//TODO
    //查看详细答题记录
    Map<String,String> getRecord(Student student);//Map<试题id，答题记录>

    //TODO 补考

    //查看错题集
    Map<String,String> getWrongAnsRec(Student student);//Map<试题id，答题记录>

    //TODO 数据分析功能 输出？

    //TODO 提问功能
}
