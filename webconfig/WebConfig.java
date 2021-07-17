package com.woo.examonline.config;

import com.woo.examonline.config.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/*开发时可以注销*/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginHanderInterceptor;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加对用户是否登录的拦截器，并添加过滤项、排除项
        registry.addInterceptor(loginHanderInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/index","/","/css/**")//排除样式、脚本、图片等资源文件
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/")//排除登录页面
//                .excludePathPatterns("/index")//排除登录页面
                .excludePathPatterns("/login")
                .excludePathPatterns("/user/login")//排除登录操作
                .excludePathPatterns("/register")//排除登录操作
                .excludePathPatterns("/student/register");//排除登录操作


    }
}
