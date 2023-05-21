package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AotowireByXMLTest {

    /**
     * 自动装配：
     * 根据指定的策略，在IOC容器中匹配某个bean，自动为bean中的类类型的属性或接口类型的属性赋值
     * 可以通过bean标签中的autowire属性设置自动装配的策略
     * 自动装配的策略：
     * no,default:不装配，即bean中的属性不会自动匹配某个bean为属性赋值，此时属性使用的是默认值
     * byTape:根据要赋值的属性的类型，在IOC容器中匹配某个bean，为属性赋值
     * 注意：
     * 1）若通过类型没有找到任何一个类型匹配的bean，此时不装配，属性是默认值
     */

    @Test
    public void testAutowire(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.savaUser();
    }
}
