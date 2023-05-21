package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {
    /**
     * ��ȡbean�����ַ�ʽ
     * 1.����bean��id��ȡ
     * 2.����bean�����ͻ�ȡ
     *ע�⣺�������ͻ�ȡbeanʱ��Ҫ��IOC����������ֻ��һ������ƥ���bean
     * 3.����bean�����ͺ�id��ȡ
     */
    @Test
    public void testIOC(){
        //��ȡIOC����
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //��ȡbean
//        Student studentOne = (Student) ioc.getBean("studentOne");
//        Student studentOne = ioc.getBean(Student.class);
        Student studentOne = ioc.getBean("studentOne", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void testDI(){
        //��ȡIOC����
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentSix", Student.class);
        System.out.println(student);
//        Clazz clazz = ioc.getBean("clazzInner", Clazz.class);
//        System.out.println(clazz);
//        Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
//        System.out.println(clazz);
    }
}
