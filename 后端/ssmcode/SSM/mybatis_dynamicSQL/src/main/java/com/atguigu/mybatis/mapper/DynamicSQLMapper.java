package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    /**
     * ����������ѯԱ����Ϣ
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * ʹ��choose��ѯԱ����Ϣ
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * �������Ա����Ϣ
     * @param emps
     */
    void insertMoreEmp(@Param("emps") List<Emp> emps);

    /**
     * ����ɾ��
     * @param empIds
     */
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
