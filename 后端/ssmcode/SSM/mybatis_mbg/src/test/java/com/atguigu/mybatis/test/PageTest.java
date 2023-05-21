package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {
    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //��ѯ����֮ǰ������ҳ����
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> list = mapper.selectByExample(null);
        //��ѯ����֮����Ի�ȡ��ҳ��ص���������
        PageInfo<Emp> pageInfo = new PageInfo<>(list,5);
        list.forEach(System.out::println);
        System.out.println(page);
        System.out.println(pageInfo);
    }
}
