package com.atguigu.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //�˷�����bean���������ڳ�ʼ��֮ǰִ��
        System.out.println("MyBeanPostProcessor-->���ô�������postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //�˷�����bean���������ڳ�ʼ��֮��ִ��
        System.out.println("MyBeanPostProcessor-->���ô�������postProcessAfterInitialization");
        return bean;
    }
}
