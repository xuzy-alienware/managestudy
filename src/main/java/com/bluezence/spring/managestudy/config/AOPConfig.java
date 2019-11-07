package com.bluezence.spring.managestudy.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * execution(public * *(..)):所有public方法，后面的星号代表路径和方法名
 * execution(* set*(..)):所有set开头的方法
 * execution(public set*(..)):所有set开头的public方法
 * execution(public com.xyz.service.* set*(..)):所有set开头的public方法，且在com.xzy.service包下
 * target(com.xzy.service.CommonService):所有实现了CommonService接口的类的方法
 * @target(org.springframework.transaction.Transactional):所有用@Transaction注解的方法
 * @within(org.springframework.stereotype.Controller):类型声明了@Controller的所有方法
 */
@Configuration
@Aspect
public class AOPConfig {

    /**
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@within(org.springframework.stereotype.Controller)")
    public Object around(final ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object[] args = pjp.getArgs();
            System.out.println("args:"+ Arrays.asList(args));
        //
            Object o = pjp.proceed();
            System.out.println("procees result:" + o);
            return o;
        } catch (Throwable e) {
            throw e;
        }
    }
}
