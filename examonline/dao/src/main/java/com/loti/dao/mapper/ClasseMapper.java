package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.Classe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClasseMapper {
    void InsertClasse(Classe classe);
    List<Classe> SelectClassByTeacher(int id);
    void updateExamById(@Param("classId") int classId,@Param("examId") int examId);
    List<Classe> SelectClassByCourse(String courseName);
}
