package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.Paper;
import com.loti.dao.pojo.Entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperMapper {
//    Paper SelectPaperByPid(int id);
//    Paper SelectPaperByCourseName(String name);
    List<Question> SelectQuesByPaperId(int id);
    void InsertPaper(Paper paper);
}
