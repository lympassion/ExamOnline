package com.loti.controller.Utils;

import com.loti.dao.pojo.Entity.User.Student;
import com.loti.dao.pojo.Entity.User.Teacher;

import java.util.Map;

public class FormatUtil {
    public static int GenderFormat(String gender){
        if(gender.equals("male"))
            return 0;
        if(gender.equals("female"))
            return 1;
        else return -1;
    }


}
