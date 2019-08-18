package com.zhangwenyu.resource.interceptor;

import com.zhangwenyu.resource.bean.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 自定义拦截器
 */
public class LoginInterceptor  extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        //System.out.println("session="+user);
        if(user==null){
            response.sendRedirect(request.getContextPath()+"/utils.jsp?page=login");
            return false;
        }
        return true;
    }
}
