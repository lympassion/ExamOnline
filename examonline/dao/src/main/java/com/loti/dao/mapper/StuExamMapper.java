package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.StudentExam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StuExamMapper {
    StudentExam SelectStuExamById(@Param("examId") int examId,@Param("stuId") int stuId,@Param("quesId") int quesId);
    void InsertStuExam(StudentExam studentExam);
    void InsertInitStuExamByClass(@Param("classId") int classId,@Param("examId") int examId);
    List<StudentExam> getStuExamByExamStu(@Param("examId") int exam_id,@Param("stuId") int stu_id);
    void updateScore(@Param("examId") int examId,@Param("stuId") int stuId,
                        @Param("quesId") int quesId,@Param("score") int score);
    int getStuExamTypeCnt(@Param("stuId") int stuId,@Param("examId") int examId,@Param("type") int type);

    List<Double> getRateByExam(@Param("examId") int examId,@Param("paperId") int paperId,
                               @Param("score0") int score0,@Param("score1") int score1,
                               @Param("score2") int score2,@Param("score3") int score3,
                               @Param("score4") int score4);
}
