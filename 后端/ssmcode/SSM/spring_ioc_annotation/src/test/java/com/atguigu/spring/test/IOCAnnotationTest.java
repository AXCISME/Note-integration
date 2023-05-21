package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import com.atguigu.spring.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCAnnotationTest {

    /**
     * @Component:�����ʶΪ��ͨ���
     * @Controller:�����ʶΪ���Ʋ����
     * @Service:�����ʶΪҵ������
     * @Repository:�����ʶΪ�־ò����
     *
     * ͨ��ע��+ɨ�������õ�bean��id��Ĭ��ֵΪ���С�շ壬������������ĸΪСд�Ľ��
     * ����ͨ����ʶ�����ע���value����ֵ����bean���Զ����id
     *
     * @Autowired:ʵ���Զ�װ�书�ܵ�ע��
     * 1.@Autowiredע���ܺ��ʶ��λ��
     * a>��ʶ�ڳ�Ա��������ʱ����Ҫ���ó�Ա������set����
     * b>��ʶ��set()������
     * c>Ϊ��ǰ��Ա������ֵ���вι�����
     * 2.@Autowiredע��ԭ��
     * a>Ĭ��ͨ��byType�ķ�ʽ����IOC������ͨ������ƥ��ĳ��beanΪ���Ը�ֵ
     * b>���ж������ƥ���bean����ʱ���Զ�ת��ΪbyName�ķ�ʽʵ���Զ�װ���Ч��
     * ����Ҫ��ֵ�����Ե���������Ϊbean��idƥ��ĳ��beanΪ���Ը�ֵ
     * c>��byType��byName���޷�ʵ���Զ�װ�䣬��IOC�������ж������ƥ���bean
     * ����Щbean��id��Ҫ��ֵ�����Ե�����������һ�£���ʱ���쳣
     * d>��ʱ������Ҫ��ֵ�������ϣ����һ��ע��@Qualifier("")
     * ͨ����ע���value����ֵ��ָ��ĳ��bean��id�����beanΪ���Ը�ֵ
     *
     * ע�⣺��IOC������û���κ�һ������ƥ���bean����ʱ�׳��쳣��NoSuchBeanDefinitionException
     * ��@Autowiredע�����и�����required��Ĭ��ֵΪtrue��Ҫ���������Զ�װ��
     * ���Խ�required����Ϊfalse����ʱ��װ����װ�䣬�޷�װ����ʹ�����Ե�Ĭ��ֵ
     */

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
//        System.out.println(userController);
//        UserService userService = ioc.getBean("userServiceImpl",UserService.class);
//        System.out.println(userService);
//        UserDao user = ioc.getBean(UserDao.class);
//        System.out.println(userService);
        userController.saveUser();
    }
}
