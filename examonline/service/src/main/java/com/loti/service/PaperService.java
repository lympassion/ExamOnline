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
    //根据试卷获取试卷下所有考题
    List<Question> getQuesByPaperId(int paper_id);
    //略略略
    List<RealPaper> getAllRealPaper();
    List<Integer> getAllRPaperId();
    //根据课程名称获取试卷试题信息
    List<Integer> getRPaperIdByCourse(String courseName);
    //获取试卷试题部分参数
    RealPaper getRealPaperById(int paper_id);
    int getPaperScoreById(int paper_id);
    //试卷试题类型统计 根据类型和总体的
    int getTypeCnt(int type,int paper_id);
    int getAllCnt(int paper_id);
    //获取试题在试卷顺序
    int getOrderByPaperAndQues(int ques_id,int paper_id);
    //获取试卷名称
    String getPaperNameById(int id);
    //略略略
    void InsertPaper(Paper paper);
    void InsertRealPaper(RealPaper realPaper);
    //更新试卷客观题与主观题总分
    void updateScorePart1(int paper_id,int score);
    void updateScorePart2(int paper_id,int score);
    void updateScore(int paper_id,int score);

    void DeleteRPaperById(int paper_id);
}
