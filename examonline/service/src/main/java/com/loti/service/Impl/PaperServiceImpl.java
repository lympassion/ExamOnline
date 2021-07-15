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


}
