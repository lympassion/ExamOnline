package com.loti.service;

import com.loti.dao.pojo.Entity.User.User;

public interface UserService {
    //根据用户id获取用户
    User getUserById(String id);
    //判断用户是否合法（）
    User getUserByUsrAndPass(String id,String pwd);
}
