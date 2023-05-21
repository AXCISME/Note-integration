package com.atguigu.spring.test;

import com.atguigu.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void test(){
        //��ȡIOC����
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //��ȡIOC�����е�bean����
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloword");
        helloworld.sayHello();
    }
}
