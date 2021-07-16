package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.StudentExam;
import org.apache.ibatis.annotations.Param;

public interface StuExamMapper {
    StudentExam SelectStuExamById(@Param("examId") int examId,@Param("stuId") int stuId,@Param("quesId") int quesId);
    void InsertStuExam(StudentExam studentExam);
    void InsertInitStuExamByClass(@Param("classId") int classId,@Param("examId") int examId);
}
