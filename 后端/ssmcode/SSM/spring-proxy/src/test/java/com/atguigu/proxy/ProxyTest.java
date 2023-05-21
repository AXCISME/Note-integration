package com.atguigu.proxy;

import com.atguigu.spring.proxy.Calculator;
import com.atguigu.spring.proxy.CalculatorImpl;
import com.atguigu.spring.proxy.CalculatorStaticProxy;
import com.atguigu.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {

    /**
     * ��̬���������֣�
     * 1.jdk��̬����Ҫ������нӿڣ��������ɵĴ�������com.sun.proxy���£�����Ϊ$proxy2
     * 2.cglib��̬����,�������ɵĴ������̳�Ŀ���࣬���Һ�Ŀ��������ͬ�İ���
     */

    @Test
    public void testProxy(){
//        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
//        proxy.add(1,2);

        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,2);
    }
}
