package com.atguigu.spring.service;

public interface CheckoutService {

    /**
     * Ω·’À
     * @param userId
     * @param bookIds
     */
    void checkout(Integer userId, Integer[] bookIds);
}
