package com.atguigu.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy(){

        /**
         * ClassLoader loader:ָ�����ض�̬���ɵĴ�������������
         * Class[] interfaces:��ȡĿ�����ʵ�ֵ����еĽӿڵ�class���������
         * InvocationHandler h:���ô������еĳ��󷽷������д
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("��־��������"+method.getName()+"������"+ Arrays.toString(args));
                    //proxy��ʾ�������method��ʾҪִ�еķ�����args��ʾҪִ�еķ����Ĳ����б�
                    result = method.invoke(target, args);
                    System.out.println("��־��������"+method.getName()+"�����"+result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("��־��������"+method.getName()+"�쳣��"+e);
                }  finally {
                    System.out.println("��־��������"+method.getName()+"����ִ�����");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,h);
    }
}
