package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.QuesSet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuesSetMapper {
    List<QuesSet> selectQuesSetByStu(int stuId);
    void insertQuesSet(QuesSet quesSet);
    QuesSet selectQues(@Param("stuId") int stuId,@Param("quesId") int quesId);
}
