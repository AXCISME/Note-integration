package com.atguigu.spring.dao;

public interface BookDao {
    /**
     * ����ͼ���id��ѯͼ��ļ۸�
     * @param bookId
     * @return
     */
    Integer getPriceByBookId(Integer bookId);

    /**
     * ����ͼ��Ŀ��
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * �����û������
     * @param userId
     * @param price
     */
    void updateBalance(Integer userId, Integer price);
}
