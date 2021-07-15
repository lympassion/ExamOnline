package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.StudentPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StuPaperMapper {
    //通过学生id和考试id判断是否参加考试
    int SelectMarkByExamAndStudent(@Param("examId") int examId, @Param("stuId") int studentId);
    //通过学生id查看考试
    List<StudentPaper> SelectStuPaperByRecId(int id);
    //通过学生id和考试id使得其验证参加考试
    void updateStudentTestInfoById(@Param("examId") int examId, @Param("stuId") int studentId);
    void InsertStuPaper(StudentPaper studentPaper);
}
