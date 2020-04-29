import bean.FenYe;
import bean.User;
import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    //    InputStream resourceAsStream=null;
//    SqlSession sqlSession=null;
//    UserDao mapper=null;
    @Test
//    @Before
    public void before() throws IOException {
        //（1）读取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //（2）创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //（3）使用SqlSessionFactoryBuilder创建SqlSessionFactory
        SqlSessionFactory factory = builder.build(resourceAsStream);
        //（4）使用SqlSessionFactory创建SqlSession
        SqlSession sqlSession1 = factory.openSession(true);
        SqlSession sqlSession2 = factory.openSession(true);
        //（5）使用SqlSession创建dao接口的代理对象
        UserDao mapper = sqlSession1.getMapper(UserDao.class);
        List<User> allUser = mapper.findAllUser();
        sqlSession1.close();

        UserDao mapper1 = sqlSession2.getMapper(UserDao.class);
        List<User> allUser1 = mapper1.findAllUser();
        sqlSession2.close();
        System.out.println(allUser);
        System.out.println(allUser1);
        System.out.println(allUser.hashCode());
        System.out.println(allUser1.hashCode());


        resourceAsStream.close();
    }
    @Test
//    @Before
    public void before1() throws IOException {
        //（1）读取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //（2）创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //（3）使用SqlSessionFactoryBuilder创建SqlSessionFactory
        SqlSessionFactory factory = builder.build(resourceAsStream);
        //（4）使用SqlSessionFactory创建SqlSession
        SqlSession sqlSession1 = factory.openSession(true);

        //（5）使用SqlSession创建dao接口的代理对象
        UserDao mapper = sqlSession1.getMapper(UserDao.class);
        List<User> allUser = mapper.findAllUser();
        List<User> allUser1 = mapper.findAllUser();
        sqlSession1.close();
        System.out.println(allUser);
        System.out.println(allUser1);
        System.out.println(allUser.hashCode());
        System.out.println(allUser1.hashCode());


        resourceAsStream.close();
    }

}
//    @After
//    public void after() throws IOException {
//
//
//    }
//    @Test
//    public void findAllUser() throws IOException {
//
//        //（6）使用代理对象执行方法
//        List<User> allUser = mapper.findAllUser();
//        System.out.println(allUser);
//
//
//    }
//    @Test
//    public void moHuChaXun(){
//        User user=new User();
//        user.setUusername("%王%");
//        user.setAddress("%太原%");
//        List<User> users = mapper.moHuChaXun(user);
//        System.out.println(users);
//    }
//    @Test
//     public void delete(){
//        List list=new ArrayList();
//        list.add(54);
//        list.add(53);
//        list.add(52);
//        mapper.delete(list);
//
//
//}}
