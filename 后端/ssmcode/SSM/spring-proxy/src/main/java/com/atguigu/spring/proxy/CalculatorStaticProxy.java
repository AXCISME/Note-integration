package com.atguigu.spring.proxy;

public class CalculatorStaticProxy implements Calculator{

    private CalculatorImpl target;

    public CalculatorStaticProxy(CalculatorImpl target) {
        this.target = target;
    }

    @Override
    public int add(int i, int j) {
        int result = 0;
        try {
            System.out.println("��־��������add��������" + i + "," + j);
            result = target.add(i, j);
            System.out.println("��־��������add�������" + result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("��־��������sub��������" + i + "," + j);
        int result = target.add(i, j);
        System.out.println("��־��������sub�������" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("��־��������mul��������" + i + "," + j);
        int result = target.add(i, j);
        System.out.println("��־��������mul�������" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("��־��������div��������" + i + "," + j);
        int result = target.add(i, j);
        System.out.println("��־��������div�������" + result);
        return result;
    }
}
