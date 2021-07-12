package com.loti.controller.config;


import com.loti.service.Impl.ExamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ExamUserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**","/image/**","/fonts/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/login","/login.html").permitAll()
                .antMatchers("/register","/register.html").permitAll()
//                .antMatchers("/teacher/**").hasRole("teacher")
//                .antMatchers("/student/**").hasRole("student")
//                .anyRequest().authenticated()
        ;
        http.formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll();
        http.headers().frameOptions().disable();
        http.csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
