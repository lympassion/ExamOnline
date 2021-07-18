package com.loti.service.Impl;

import com.loti.dao.mapper.PaperMapper;
import com.loti.dao.mapper.RPaperMapper;
import com.loti.dao.pojo.Entity.Paper;
import com.loti.dao.pojo.Entity.Question;
import com.loti.dao.pojo.Entity.RealPaper;
import com.loti.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaperServiceImpl implements PaperService {

    @Autowired(required = false)
    private PaperMapper paperMapper;
    @Autowired(required = false)
    private RPaperMapper rPaperMapper;

    @Override
    public List<Question> getQuesByPaperId(int paper_id) {
        return paperMapper.SelectQuesByPaperId(paper_id);
    }

    @Override
    public void InsertPaper(Paper paper) {
        paperMapper.InsertPaper(paper);
    }

    @Override
    public void InsertRealPaper(RealPaper realPaper) {
        rPaperMapper.InsertRPaper(realPaper);
    }

    @Override
    public List<RealPaper> getAllRealPaper() {
        return rPaperMapper.getAllRealPaper();
    }

    @Override
    public void updateScore(int paper_id, int score) {
        rPaperMapper.updateScoreById(paper_id,score);
    }

    @Override
    public void DeleteRPaperById(int paper_id) {
        rPaperMapper.RemoveRPaperById(paper_id);
    }

    @Override
    public List<Integer> getAllRPaperId() {
        return rPaperMapper.getAllRPaperId();
    }

    @Override
    public int getPaperScoreById(int paper_id) {
        return rPaperMapper.getScoreById(paper_id);
    }

    @Override
    public int getTypeCnt(int type, int paper_id) {
        return paperMapper.getTypeCnt(type,paper_id);
    }

    @Override
    public List<Integer> getRPaperIdByCourse(String courseName) {
        return rPaperMapper.getRPaperIdByCourse(courseName);
    }

    @Override
    public RealPaper getRealPaperById(int paper_id) {
        return rPaperMapper.SelectRPaperById(paper_id);
    }

    @Override
    public String getPaperNameById(int id) {
        return rPaperMapper.getPaperNameById(id);
    }

    @Override
    public int getOrderByPaperAndQues(int ques_id, int paper_id) {
        return paperMapper.getOrderByPaperAndQues(ques_id,paper_id);
    }

    @Override
    public void updateScorePart1(int paper_id, int score) {
        rPaperMapper.updateScorePart1(paper_id,score);
    }

    @Override
    public void updateScorePart2(int paper_id, int score) {
        rPaperMapper.updateScorePart2(paper_id,score);
    }
}
