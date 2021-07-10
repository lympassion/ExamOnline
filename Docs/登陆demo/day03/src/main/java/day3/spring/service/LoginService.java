package day3.spring.service;

import day3.spring.domain.AjaxResult;
import day3.spring.domain.User;


public interface LoginService {
    public AjaxResult login(User user);
}
