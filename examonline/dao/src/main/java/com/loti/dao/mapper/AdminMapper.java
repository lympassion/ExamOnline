package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.User.Admin;
import com.loti.dao.pojo.Entity.User.MyUser;

public interface AdminMapper {
    Admin selectByIdAndPass(MyUser user);
    Admin selectAdminById(int id);
}
