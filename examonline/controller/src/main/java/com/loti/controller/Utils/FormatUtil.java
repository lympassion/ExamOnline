package com.loti.controller.Utils;

import com.loti.dao.pojo.Entity.User.Student;
import com.loti.dao.pojo.Entity.User.Teacher;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Map;

public class FormatUtil {
    public static final int SINGLE_CHOICE = 0;
    public static final int MUTI_CHOICE = 1;
    public static final int JUDGE = 2;
    public static final int BLANK = 3;
    public static final int SUBJECT = 4;

    public static final int SCORE_CHOICE = 5;
    public static final int SCORE_CHOICE_PART = 3;
    public static final int SCORE_JUDGE = 5;
    public static final int SCORE_BLANK = 5;
    public static final int SCORE_SUB = 15;
    public static final int SCORE_ERROR = 0;
    public static final int ERROR = -1;

    public static int GenderFormat(String gender){
        if(gender.equals("male"))
            return 0;
        if(gender.equals("female"))
            return 1;
        else return -1;
    }

    public static int JudgeScore(int type,String stu_ans,String corr_ans){
        switch (type){
            case SINGLE_CHOICE:
                if(stu_ans.equals(corr_ans))
                    return SCORE_CHOICE;
                else return SCORE_ERROR;
            case MUTI_CHOICE:
                if(stu_ans.equals(corr_ans))
                    return SCORE_CHOICE;
                else if(corr_ans.contains(stu_ans))
                    return SCORE_CHOICE_PART;
                return SCORE_ERROR;
            case JUDGE:
                if(stu_ans.equals(corr_ans))
                    return SCORE_JUDGE;
                else return SCORE_ERROR;
            case BLANK:
                if(stu_ans.equals(corr_ans))
                    return SCORE_BLANK;
                else return SCORE_ERROR;
            default:return ERROR;
        }
    }

    public static int getFirstNum(int id){
        return Integer.parseInt(String.valueOf(id).substring(0,1));
    }


}
