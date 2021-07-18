package com.loti.dao.pojo.Entity;

import org.springframework.stereotype.Component;

@Component
public class RealPaper {
    int paperId;
    String paperName;
    String courseName;
    int paperScore;
    int paperScorePart1;
    int paperScorePart2;

    public RealPaper(){}
    public RealPaper(int paperId, String paperName, String courseName, int paperScore) {
        this.paperId = paperId;
        this.paperName = paperName;
        this.courseName = courseName;
        this.paperScore = paperScore;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(int paperScore) {
        this.paperScore = paperScore;
    }

    public int getPaperScorePart1() {
        return paperScorePart1;
    }

    public void setPaperScorePart1(int paperScorePart1) {
        this.paperScorePart1 = paperScorePart1;
    }

    public int getPaperScorePart2() {
        return paperScorePart2;
    }

    public void setPaperScorePart2(int paperScorePart2) {
        this.paperScorePart2 = paperScorePart2;
    }
}
