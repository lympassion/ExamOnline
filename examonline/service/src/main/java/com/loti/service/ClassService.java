package com.loti.service;

import com.loti.dao.pojo.Entity.Classe;
import com.loti.dao.pojo.Entity.StudentClass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {
    void InsertClass(Classe classe);
    void updateExamById(int class_id,int exam_id);
    void InsertStuClass(StudentClass studentClass);
    List<Classe> SelectClassByCourse(String course_name);
}
