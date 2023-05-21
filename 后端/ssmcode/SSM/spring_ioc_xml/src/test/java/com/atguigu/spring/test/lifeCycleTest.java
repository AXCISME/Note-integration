package com.atguigu.spring.test;

import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class lifeCycleTest {
    /**
     * 1.ʵ����
     * 2.����ע��
     * 3.��ʼ��
     * 4.IOC�ر�ʱ����
     *
     * ע�⣺
     * ��bean��������Ϊ����ʱ���������ڵ�ǰ����������ڻ�ȡIOC����ʱִ��
     * ��bean��������Ϊ����ʱ���������ڵ�ǰ����������ڻ�ȡbean����ʱִ��
     */
    @Test
    public void test(){
        //ConfigurableApplicationContext��ApplicationContext���ӽӿڣ�������չ��ˢ�º͹ر������ķ���
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}
