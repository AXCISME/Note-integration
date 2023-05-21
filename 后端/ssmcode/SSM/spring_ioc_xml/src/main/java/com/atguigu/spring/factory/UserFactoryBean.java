package com.atguigu.spring.factory;

import com.atguigu.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBeanʱһ���ӿڣ���Ҫ����һ����ʵ�ָýӿ�
 * ����������������
 * getObject():ͨ��һ�����󽻸�IOC��������
 * getObjectType():�������ṩ���������
 * isSingleton():���ṩ�Ķ����Ƿ���
 * ����FactoryBean��ʵ��������Ϊbeanʱ���Ὣ��ǰ����getObject()�����صĶ��󽻸�IOC��������
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
