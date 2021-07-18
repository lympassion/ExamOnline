package com.loti.service;

import com.loti.dao.pojo.Entity.Paper;
import com.loti.dao.pojo.Entity.Question;
import com.loti.dao.pojo.Entity.RealPaper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import sun.rmi.log.LogInputStream;

import java.util.List;

@Service
public interface PaperService {
    List<Question> getQuesByPaperId(int paper_id);
    List<RealPaper> getAllRealPaper();
    List<Integer> getAllRPaperId();
    List<Integer> getRPaperIdByCourse(String courseName);
    RealPaper getRealPaperById(int paper_id);
    int getPaperScoreById(int paper_id);
    int getTypeCnt(int type,int paper_id);
    int getOrderByPaperAndQues(int ques_id,int paper_id);
    String getPaperNameById(int id);
    void InsertPaper(Paper paper);
    void InsertRealPaper(RealPaper realPaper);
    void updateScorePart1(int paper_id,int score);
    void updateScorePart2(int paper_id,int score);
    void updateScore(int paper_id,int score);
    void DeleteRPaperById(int paper_id);
}
