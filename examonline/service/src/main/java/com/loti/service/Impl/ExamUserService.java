package com.loti.service.Impl;

import com.loti.dao.pojo.Entity.User.MyUser;
import com.loti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExamUserService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = (MyUser) userService.checkUserById(Integer.parseInt(username));
        if(user ==null){
            throw new UsernameNotFoundException("User not exist");
        }
        List<GrantedAuthority> grantedAuthorities= new ArrayList<>();
        if(username.substring(0, 1).equals("1")){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_student"));
        }else if(username.substring(0,1).equals("2")){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_teacher"));
        }else if(username.substring(0,1).equals("3")){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_admin"));
        }

        return new User(username,new BCryptPasswordEncoder().encode(user.password),grantedAuthorities);
    }
}
