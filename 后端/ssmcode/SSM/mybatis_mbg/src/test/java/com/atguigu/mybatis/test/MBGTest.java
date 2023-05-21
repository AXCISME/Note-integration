package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //����id��ѯ����
//        Emp emp = mapper.selectByPrimaryKey(1);
//        System.out.println(emp);
        //��ѯ��������
//        List<Emp> list = mapper.selectByExample(null);
//        list.forEach(System.out::println);
        //����������ѯ����
//        EmpExample example = new EmpExample();
//        example.createCriteria().andEmpNameEqualTo("����").andAgeGreaterThanOrEqualTo(20);
//        example.or().andGenderEqualTo("��");
//        List<Emp> list = mapper.selectByExample(example);
//        list.forEach(System.out::println);
        //������ͨ�޸Ĺ���
        Emp emp = new Emp(1,"��",null,"Ů");
//        mapper.updateByPrimaryKey(emp);
        //����ѡ�����޸�
        mapper.updateByPrimaryKeySelective(emp);
    }
}
