package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * ͨ���ֲ���ѯ��ѯԱ���Լ�����Ӧ�Ĳ�����Ϣ�ĵڶ���
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    /**
     * ��ѯ�����Լ�������Ա����Ϣ
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * ͨ���ֲ���ѯ��ѯ���ż������е�Ա����Ϣ��һ��
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
