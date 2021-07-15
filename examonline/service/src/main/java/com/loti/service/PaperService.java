package com.loti.service;

import com.loti.dao.pojo.Entity.Paper;
import com.loti.dao.pojo.Entity.Question;
import com.loti.dao.pojo.Entity.RealPaper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaperService {
    List<Question> getQuesByPaperId(int paper_id);
    void InsertPaper(Paper paper);
    void InsertRealPaper(RealPaper realPaper);
}
