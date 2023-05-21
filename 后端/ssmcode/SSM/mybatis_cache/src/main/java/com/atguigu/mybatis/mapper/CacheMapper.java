package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    /**
     * ����Ա��id��ѯԱ����Ϣ
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);

    /**
     * ���Ա����Ϣ
     * @param emp
     */
    void insertEmp(Emp emp);

}
