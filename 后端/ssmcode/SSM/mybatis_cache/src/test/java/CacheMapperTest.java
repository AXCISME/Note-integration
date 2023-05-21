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
     * MyBatis的一级缓存：
     * MyBatis的一级缓存是SqlSession级别的，即通过同一个SqlSession查询的数据会被缓存
     * 再次使用同一个SqlSession查询同一条数据，会从缓存中获取
     * 使一级缓存失效的四种情况
     * 1)不同的SqlSession对应不同的一级缓存
     * 2)同一个SqlSession但是查询条件不同
     * 3)同一个SqlSession两次查询期间执行了任何一次增删改操作
     * 4)同一个SqlSession两次查询期间手动清空了缓存
     *
     * MyBatis的二级缓存
     * MyBatis的二级缓存是SqlSessionFactory级别，即通过同一个SqlSessionFactory所获取的SqlSession对象
     * 查询的数据会被缓存，在通过同一个SqlSessionFactory所获取的SqlSession查询相同的数据会从缓存中获取
     * MyBatis二级缓存开启条件：
     * 1)在核心配置文件中，设置全局配置属性cacheEnable="true",默认为true,不需要设置
     * 2)在映射文件中设置标签<cache/>
     * 3)二级缓存必须在SqlSession关闭或提交之后有效
     * 4)查询的数据所转换的实体类类型必须实现序列化接口
     * 使二级缓存失效的情况：
     * 两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
     */

    @Test
    public void testGetById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpById(1);
        sqlSession.clearCache();    //清缓存
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
