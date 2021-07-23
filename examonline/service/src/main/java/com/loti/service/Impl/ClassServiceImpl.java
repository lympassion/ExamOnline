package com.loti.service.Impl;

import com.loti.dao.mapper.ClasseMapper;
import com.loti.dao.mapper.StuClassMapper;
import com.loti.dao.pojo.Entity.Classe;
import com.loti.dao.pojo.Entity.StudentClass;
import com.loti.dao.pojo.Entity.Trans.TransClass;
import com.loti.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassServiceImpl implements ClassService {

    @Autowired(required = false)
    private ClasseMapper classeMapper;

    @Autowired(required = false)
    private StuClassMapper stuClassMapper;

    @Override
    public void InsertClass(Classe classe) {
        classeMapper.InsertClasse(classe);
    }

    @Override
    public void updateExamById(int class_id, int exam_id) {
        classeMapper.updateExamById(class_id,exam_id);
    }

    @Override
    public void InsertStuClass(StudentClass studentClass) {
        stuClassMapper.InsertStuClass(studentClass);
    }

    @Override
    public Classe getClassByTeacher(int teacher_id) {
        return classeMapper.SelectClassByTeacher(teacher_id);
    }

    @Override
    public List<Classe> SelectClassByCourse(String course_name) {
        return classeMapper.SelectClassByCourse(course_name);
    }

    @Override
    public List<TransClass> getAllClassInfo() {
        return classeMapper.getAllClassInfo();
    }

    @Override
    public List<String> getAllClassName() {
        return classeMapper.getAllClassName();
    }

    @Override
    public List<TransClass> getClassInfoByCourse(String courseName) {
        return classeMapper.getClassInfoByCourse(courseName);
    }
}
