package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {
    /**
     * 获取bean的三种方式
     * 1.根据bean的id获取
     * 2.根据bean的类型获取
     *注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
     * 3.根据bean的类型和id获取
     */
    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
//        Student studentOne = (Student) ioc.getBean("studentOne");
//        Student studentOne = ioc.getBean(Student.class);
        Student studentOne = ioc.getBean("studentOne", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void testDI(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentSix", Student.class);
        System.out.println(student);
//        Clazz clazz = ioc.getBean("clazzInner", Clazz.class);
//        System.out.println(clazz);
//        Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
//        System.out.println(clazz);
    }
}
