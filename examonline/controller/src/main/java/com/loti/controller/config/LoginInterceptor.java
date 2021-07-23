package com.loti.controller.config;

import com.loti.controller.Utils.FormatUtil;
import com.loti.controller.Utils.JwtUtil;
import com.loti.dao.pojo.Entity.User.MyUser;
import com.loti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("前置拦截器1 preHandle： 请求的uri为："+requestURL.toString());
        Object user = request.getSession().getAttribute("userId");
        //Object userd = request.getSession().getAttribute("logerd");
        try {
            int userId = JwtUtil.getTokenInfo((String)user).getClaim("userId").asInt();
            MyUser myUser = userService.checkUserById(userId);
            String role = FormatUtil.FormatRole(myUser.getRole());
            if(myUser!=null){
                if(request.getRequestURI().equals("/"))
                    response.sendRedirect(request.getContextPath() + "/" + role + "Main.html");
                return true;
            }else {
                request.setAttribute("msg", "没有权限先登录");
                response.sendRedirect(request.getContextPath()+"/login");
                return false;
            }
        }catch (NullPointerException e){
            request.setAttribute("msg", "token过期，请重新登录");
            response.sendRedirect(request.getContextPath()+"/index");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
