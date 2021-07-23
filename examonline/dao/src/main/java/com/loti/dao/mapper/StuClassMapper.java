package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.StudentClass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuClassMapper {
    void InsertStuClass(StudentClass studentClass);
}
