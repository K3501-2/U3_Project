package com.team.hospital.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/25 15:01
 * @Java version: 1.8.0_361
 * @Project U3_Project
 * @Package com.team.hospital.interceptor
 * @Classname LoginInterceptor
 * @Created by Administrator
 * @Description:用户拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");

        // 获取当前请求的路径
        String requestURI = request.getRequestURI();
        System.out.println("拦截到了请求：" + request.getRequestURI());

        // 判断是否为登录页面，如果是则放行
        /*if (requestURI.contains("login.html")) {
            return true;
        }

        // 判断请求路径是否为 "/user/login"，如果是，则放行
        if (requestURI.equals("/user/login")) {
            return true;
        }
        // 判断用户是否已登录，这里可以根据你的具体业务逻辑进行判断
        // 如果用户已登录，则放行
        if (request.getSession().getAttribute("loggedIn") != null) {
            System.out.println("已经登录，请求放行");
            return true;
        } else {
            // 用户未登录，跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/login.html");
            System.out.println("未登录，无法放行请求！");
            return false;
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在处理完请求后执行，可以对 ModelAndView 进行进一步的处理
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        // 在请求完成后执行，可以进行一些资源的清理操作
    }
}
