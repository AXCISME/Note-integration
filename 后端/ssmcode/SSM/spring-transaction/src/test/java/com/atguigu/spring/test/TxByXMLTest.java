package com.atguigu.spring.test;

import com.atguigu.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ����ʽ��������ò��裺
 * 1.��Spring�������ļ����������������
 * 2.���������ע������
 * 3.����Ҫ���������ķ����ϣ����@Transactionalע�⣬�÷����ͻᱻ�������
 *
 * ע�⣺����xmlʵ�ֵ�����ʽ���񣬱�������aspectj������
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXMLTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.checkout(1,new Integer[]{1,2});
    }

}
