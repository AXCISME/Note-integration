package com.atguigu.spring.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoggerAspect {

    public void beforeAdviceMethod(JoinPoint joinPoint){
        //��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        //��ȡ���ӵ�����Ӧ�� ����
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,����:"+signature.getName()+",����:"+ Arrays.toString(args));
    }

    public void afterAdviceMethod(JoinPoint joinPoint){
        //��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,����:"+signature.getName()+",ִ�����");
    }

    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        //��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,����֪ͨ"+signature.getName()+",���:"+result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        //��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,����:"+signature.getName()+",�쳣:"+ex);
    }

    //����֪ͨ�ķ�������ֵһ��Ҫ��Ŀ����󷽷��ķ���ֵһ��
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("����֪ͨ-->ǰ��֪ͨ");
            //��ʾĿ����󷽷���ִ��
            result = joinPoint.proceed();
            System.out.println("����֪ͨ-->����֪ͨ");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("����֪ͨ-->�쳣֪ͨ");
        } finally {
            System.out.println("����֪ͨ-->����֪ͨ");
        }
        return result;
    }
}
