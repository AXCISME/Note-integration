package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * ����û���Ϣ
     * @return
     */
    int insertUser();

    /**
     * �޸��û���Ϣ
     */
    void updateUser();

    /**
     * ɾ���û���Ϣ
     */
    void deleteUser();

    /**
     * ����id��ѯ�û���Ϣ
     * @return
     */
    User getUserById();

    /**
     * ��ѯ���е��û���Ϣ
     * @return
     */
    List<User> getAllUser();
}
