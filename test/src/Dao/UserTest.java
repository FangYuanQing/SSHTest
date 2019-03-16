package Dao;

import mapper.UserMapper;
import mapper.Usermapperport;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import po.User;

import java.io.IOException;
import java.io.InputStream;

public class UserTest {
    @Test
    public void findUser()
    {
        String str="SqlMapConfig.xml";
        int i=0;
        InputStream inputStream= null;
        try {
            inputStream = Resources.getResourceAsStream(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sessionFactory.openSession();
        User user= sqlSession.selectOne("test.findUserById",1);
        sqlSession.close();
        System.out.println(user.toString());
    }
    /*@Test
    public void TestFindId()
    {
        String str="SqlMapConfig.xml";
        InputStream inputStream= null;
        try {
            inputStream = Resources.getResourceAsStream(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sessionFactory.openSession();
        Usermapperport userMapper= sqlSession.getMapper(Usermapperport.class);
        User user=null;
        try {
            user=userMapper.findUserById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.toString());
    }*/
}
