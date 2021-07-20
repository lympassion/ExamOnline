package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.StudentPicture;
import org.apache.ibatis.annotations.Param;

public interface StuPicMapper {
    void InsertStuPic(StudentPicture studentPicture);
    StudentPicture SelectStuPic(@Param("stuId") int stuId,@Param("examId") int examId);
}
