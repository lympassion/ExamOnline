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
    void InsertPaper(Paper paper);
    void InsertRealPaper(RealPaper realPaper);
    List<RealPaper> getAllRealPaper();
    void updateScore(int paper_id,int score);
    void DeleteRPaperById(int paper_id);
    List<Integer> getAllRPaperId();
    int getPaperScoreById(int paper_id);
    int getTypeCnt(int type,int paper_id);
    List<Integer> getRPaperIdByCourse(String courseName);
    String getPaperNameById(int id);
    int getOrderByPaperAndQues(int ques_id,int paper_id);
}
