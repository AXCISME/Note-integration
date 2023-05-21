package com.atguigu.spring.annotation;

import com.sun.source.tree.BreakTree;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 1.在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before:前置通知，在目标对象方法执行之前执行
 * @After:后置通知，在目标对象方法finally字句中执行的
 * @AfterReturning:返回通知，在目标对象方法返回值之后执行
 * @AfterThrowing:异常通知，在目标对象方法的catch字句中执行
 *
 * 2.切入点表达式：设置在表示通知的注解的value属性中 "execution(* com.atguigu.spring.annotation.CalculatorImpl.*(..))"
 *
 * 3.重用切入点表达式
 * @Pointcut
 *
 * 4.获取连接点的信息
 * 在通知方法的参数位置，设置JoinPoint类型的参数，就可以获取连接点所对应的方法的信息
 *
 * 5.切面的优先级
 * 可以通过@Order注解的value属性设置优先级，默认值Integer的最大值
 */

@Component
@Aspect //将当前组件标识为切面
public class LoggerAspect {

    @Pointcut("execution(* com.atguigu.spring.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    //@Before("execution(public int com.atguigu.spring.annotation.CalculatorImpl.add(int,int))")
//    @Before("execution(* com.atguigu.spring.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的 参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法:"+signature.getName()+",参数:"+ Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:"+signature.getName()+",执行完毕");
    }

    /**
     * 在返回通知中若要获取目标对象方法的返回值，
     * 只需要通过@AfterReturning注解的returning属性
     * 就可以将通知方法的某个参数指定为接收目标对象方法的返回值的参数
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,返回通知"+signature.getName()+",结果:"+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:"+signature.getName()+",异常:"+ex);
    }

    @Around("pointCut()")
    //环绕通知的方法返回值一定要和目标对象方法的返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知-->前置通知");
            //表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        } finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }
}
