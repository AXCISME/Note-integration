package com.atguigu.spring.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class ValidateAspect {

//    @Before("execution(* com.atguigu.spring.annotation.CalculatorImpl.*(..))")
    @Before("com.atguigu.spring.annotation.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect-->ǰ��֪ͨ");
    }
}
