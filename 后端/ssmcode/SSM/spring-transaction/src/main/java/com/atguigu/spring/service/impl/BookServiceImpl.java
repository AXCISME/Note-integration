package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
//    @Transactional(
//            //readOnly = false,   //����ֻ��
//            //timeout = 3 //���ó�ʱʱ��
//            //noRollbackFor = ArithmeticException.class
////            noRollbackForClassName = "java.lang.ArithmeticException"
////            isolation = Isolation.DEFAULT   //���ø��뼶��
//            propagation = Propagation.REQUIRES_NEW  //��������Ĵ�����Ϊ
//    )
    public void buyBook(Integer userId, Integer bookId) {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //��ѯͼ��ļ۸�
        Integer price = bookDao.getPriceByBookId(bookId);
        //����ͼ��Ŀ��
        bookDao.updateStock(bookId);
        //�����û������
        bookDao.updateBalance(userId,price);
//        System.out.println(1/0);
    }
}
