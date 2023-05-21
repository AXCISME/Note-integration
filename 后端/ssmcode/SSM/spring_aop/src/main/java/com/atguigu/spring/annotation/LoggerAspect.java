package com.atguigu.spring.annotation;

import com.sun.source.tree.BreakTree;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 1.�������У���Ҫͨ��ָ����ע�⽫������ʶΪ֪ͨ����
 * @Before:ǰ��֪ͨ����Ŀ����󷽷�ִ��֮ǰִ��
 * @After:����֪ͨ����Ŀ����󷽷�finally�־���ִ�е�
 * @AfterReturning:����֪ͨ����Ŀ����󷽷�����ֵ֮��ִ��
 * @AfterThrowing:�쳣֪ͨ����Ŀ����󷽷���catch�־���ִ��
 *
 * 2.�������ʽ�������ڱ�ʾ֪ͨ��ע���value������ "execution(* com.atguigu.spring.annotation.CalculatorImpl.*(..))"
 *
 * 3.�����������ʽ
 * @Pointcut
 *
 * 4.��ȡ���ӵ����Ϣ
 * ��֪ͨ�����Ĳ���λ�ã�����JoinPoint���͵Ĳ������Ϳ��Ի�ȡ���ӵ�����Ӧ�ķ�������Ϣ
 *
 * 5.��������ȼ�
 * ����ͨ��@Orderע���value�����������ȼ���Ĭ��ֵInteger�����ֵ
 */

@Component
@Aspect //����ǰ�����ʶΪ����
public class LoggerAspect {

    @Pointcut("execution(* com.atguigu.spring.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    //@Before("execution(public int com.atguigu.spring.annotation.CalculatorImpl.add(int,int))")
//    @Before("execution(* com.atguigu.spring.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        //��ȡ���ӵ�����Ӧ�� ����
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,����:"+signature.getName()+",����:"+ Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        //��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,����:"+signature.getName()+",ִ�����");
    }

    /**
     * �ڷ���֪ͨ����Ҫ��ȡĿ����󷽷��ķ���ֵ��
     * ֻ��Ҫͨ��@AfterReturningע���returning����
     * �Ϳ��Խ�֪ͨ������ĳ������ָ��Ϊ����Ŀ����󷽷��ķ���ֵ�Ĳ���
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        //��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,����֪ͨ"+signature.getName()+",���:"+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        //��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,����:"+signature.getName()+",�쳣:"+ex);
    }

    @Around("pointCut()")
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
