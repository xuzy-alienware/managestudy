package com.bluezence.spring.managestudy.conf;

import com.bluezence.spring.managestudy.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    //拦截器
    public void addInterceptors(InterceptorRegistry registry){
        //registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/login/**");
    }

    class SessionHandlerInterceptor implements HandlerInterceptor{
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
            User u = (User) request.getSession().getAttribute("user");
            if(u == null){
                System.out.println(111);
                response.sendRedirect("/hello.html");
                return false;
            }
            return true;
        }
    }
}
