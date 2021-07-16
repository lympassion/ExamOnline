package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.RealPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RPaperMapper {
    void InsertRPaper(RealPaper paper);
    RealPaper SelectRPaperByName(String name);
    List<RealPaper> getAllRealPaper();
    int getScoreById(int paperId);
    void updateScoreById(@Param("paperId") int paperId,@Param("score") int score);
    void RemoveRPaperById(int id);
    List<Integer> getAllRPaperId();
}
