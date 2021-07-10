package day3.spring.controller;


import day3.spring.domain.AjaxResult;
import day3.spring.domain.User;
import day3.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    private AjaxResult login(@RequestBody User user){
        return loginService.login(user);
    }
}
