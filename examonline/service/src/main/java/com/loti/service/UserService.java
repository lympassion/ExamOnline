package com.loti.service;

import com.loti.dao.pojo.Entity.User.MyUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    //查找数据库是否有该用户
    MyUser checkUser(MyUser user);
    MyUser checkUserById(int id);
}
