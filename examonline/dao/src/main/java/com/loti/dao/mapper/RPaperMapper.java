package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.RealPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RPaperMapper {
    RealPaper SelectRPaperByName(String name);
    RealPaper SelectRPaperById(int paperId);
    int getScoreById(int paperId);
    List<RealPaper> getAllRealPaper();
    List<Integer> getAllRPaperId();
    List<Integer> getRPaperIdByCourse(String courseName);
    String getPaperNameById(int id);
    void InsertRPaper(RealPaper paper);
    void updateScoreById(@Param("paperId") int paperId,@Param("score") int score);
    void updateScorePart1(@Param("paperId") int paperId,@Param("score") int score);
    void updateScorePart2(@Param("paperId") int paperId,@Param("score") int score);
    void RemoveRPaperById(int id);
}
