package com.atguigu.spring.service;

public interface CheckoutService {

    /**
     * ����
     * @param userId
     * @param bookIds
     */
    void checkout(Integer userId, Integer[] bookIds);
}
