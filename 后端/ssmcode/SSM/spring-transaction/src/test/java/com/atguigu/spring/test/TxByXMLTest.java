package com.atguigu.spring.test;

import com.atguigu.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 声明式事务的配置步骤：
 * 1.在Spring的配置文件中配置事务管理器
 * 2.开启事务的注解驱动
 * 3.在需要被事务管理的方法上，添加@Transactional注解，该方法就会被事务管理
 *
 * 注意：基于xml实现的声明式事务，必须引入aspectj的依赖
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
