package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.StudentPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StuPaperMapper {
    //通过学生id和考试id判断是否参加考试
    int SelectMarkByExamAndStudent(@Param("examId") int examId, @Param("stuId") int studentId);
    //获取主观题客观题得分
    int selectScorePart1(@Param("examId") int examId, @Param("stuId") int studentId);
    int selectScorePart2(@Param("examId") int examId, @Param("stuId") int studentId);
    int selectStuCntBySec(@Param("examId") int examId,@Param("upperBound") double up,@Param("lowerBound") double lower);
    //通过学生id查看考试
    List<StudentPaper> SelectStuPaperByStuId(int id);
    List<StudentPaper> SelectStuPaperByExamId(int id);
    //通过学生id和考试id使得其验证参加考试
    void updateStudentTestInfoById(@Param("examId") int examId, @Param("stuId") int studentId);
    void InsertStuPaper(StudentPaper studentPaper);
    void updateScorePart1(@Param("examId") int examId, @Param("stuId") int studentId, @Param("score") int scorePart1);
    void updateScorePart2(@Param("examId") int examId, @Param("stuId") int studentId, @Param("score") int scorePart2);
    void updateScore(@Param("examId") int examId, @Param("stuId") int studentId, @Param("score") int score);
}
