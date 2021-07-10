package com.loti.controller.Router;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/tologin")
    public String login(){
        //TODO
        return "auth/login";
    }

    @RequestMapping("/register")
    public String logout(){
        //TODO
        return  "auth/register";
    }
}
