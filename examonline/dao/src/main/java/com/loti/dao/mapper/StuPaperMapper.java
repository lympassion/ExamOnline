package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.StudentPaper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuPaperMapper {
    //通过学生id和考试id判断是否参加考试
    int SelectMarkByExamAndStudent(int examId,int studentId);
    //通过学生id查看考试
    StudentPaper SelectStuPaperByRecId(int id);

}
