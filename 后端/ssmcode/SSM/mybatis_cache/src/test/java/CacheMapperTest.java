import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {

    /**
     * MyBatis��һ�����棺
     * MyBatis��һ��������SqlSession����ģ���ͨ��ͬһ��SqlSession��ѯ�����ݻᱻ����
     * �ٴ�ʹ��ͬһ��SqlSession��ѯͬһ�����ݣ���ӻ����л�ȡ
     * ʹһ������ʧЧ���������
     * 1)��ͬ��SqlSession��Ӧ��ͬ��һ������
     * 2)ͬһ��SqlSession���ǲ�ѯ������ͬ
     * 3)ͬһ��SqlSession���β�ѯ�ڼ�ִ�����κ�һ����ɾ�Ĳ���
     * 4)ͬһ��SqlSession���β�ѯ�ڼ��ֶ�����˻���
     *
     * MyBatis�Ķ�������
     * MyBatis�Ķ���������SqlSessionFactory���𣬼�ͨ��ͬһ��SqlSessionFactory����ȡ��SqlSession����
     * ��ѯ�����ݻᱻ���棬��ͨ��ͬһ��SqlSessionFactory����ȡ��SqlSession��ѯ��ͬ�����ݻ�ӻ����л�ȡ
     * MyBatis�������濪��������
     * 1)�ں��������ļ��У�����ȫ����������cacheEnable="true",Ĭ��Ϊtrue,����Ҫ����
     * 2)��ӳ���ļ������ñ�ǩ<cache/>
     * 3)�������������SqlSession�رջ��ύ֮����Ч
     * 4)��ѯ��������ת����ʵ�������ͱ���ʵ�����л��ӿ�
     * ʹ��������ʧЧ�������
     * ���β�ѯ֮��ִ�����������ɾ�ģ���ʹһ���Ͷ�������ͬʱʧЧ
     */

    @Test
    public void testGetById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpById(1);
        sqlSession.clearCache();    //�建��
        System.out.println(emp);
    }

    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
        sqlSession2.close();
    }
}
