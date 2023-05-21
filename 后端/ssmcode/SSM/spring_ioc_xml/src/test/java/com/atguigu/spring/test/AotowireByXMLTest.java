package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AotowireByXMLTest {

    /**
     * �Զ�װ�䣺
     * ����ָ���Ĳ��ԣ���IOC������ƥ��ĳ��bean���Զ�Ϊbean�е������͵����Ի�ӿ����͵����Ը�ֵ
     * ����ͨ��bean��ǩ�е�autowire���������Զ�װ��Ĳ���
     * �Զ�װ��Ĳ��ԣ�
     * no,default:��װ�䣬��bean�е����Բ����Զ�ƥ��ĳ��beanΪ���Ը�ֵ����ʱ����ʹ�õ���Ĭ��ֵ
     * byTape:����Ҫ��ֵ�����Ե����ͣ���IOC������ƥ��ĳ��bean��Ϊ���Ը�ֵ
     * ע�⣺
     * 1����ͨ������û���ҵ��κ�һ������ƥ���bean����ʱ��װ�䣬������Ĭ��ֵ
     */

    @Test
    public void testAutowire(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.savaUser();
    }
}
