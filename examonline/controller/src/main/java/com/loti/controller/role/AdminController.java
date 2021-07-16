package com.loti.controller.role;

import com.loti.dao.pojo.Entity.Classe;
import com.loti.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/getAllClass",method = RequestMethod.GET)
    @ResponseBody
    public List<Classe> getAllPaper(@RequestParam("cname") String courseName){
        return classService.SelectClassByCourse(courseName);
    }

}
