package com.loti.controller.trans;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class MarkQues {
    @JsonFormat(shape = JsonFormat.Shape.NUMBER,timezone = "GMT+8")
    Timestamp addTime;
    int quesType;
    int quesId;
    String quesTitle;
    String opa;
    String opb;
    String opc;
    String opd;
    String opRight;

    public MarkQues(Timestamp addTime, int quesType, int quesId, String quesTitle, String opa, String opb, String opc, String opd, String opRight) {
        this.addTime = addTime;
        this.quesType = quesType;
        this.quesId = quesId;
        this.quesTitle = quesTitle;
        this.opa = opa;
        this.opb = opb;
        this.opc = opc;
        this.opd = opd;
        this.opRight = opRight;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public int getQuesType() {
        return quesType;
    }

    public void setQuesType(int quesType) {
        this.quesType = quesType;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getQuesTitle() {
        return quesTitle;
    }

    public void setQuesTitle(String quesTitle) {
        this.quesTitle = quesTitle;
    }

    public String getOpa() {
        return opa;
    }

    public void setOpa(String opa) {
        this.opa = opa;
    }

    public String getOpb() {
        return opb;
    }

    public void setOpb(String opb) {
        this.opb = opb;
    }

    public String getOpc() {
        return opc;
    }

    public void setOpc(String opc) {
        this.opc = opc;
    }

    public String getOpd() {
        return opd;
    }

    public void setOpd(String opd) {
        this.opd = opd;
    }

    public String getOpRight() {
        return opRight;
    }

    public void setOpRight(String opRight) {
        this.opRight = opRight;
    }
}
