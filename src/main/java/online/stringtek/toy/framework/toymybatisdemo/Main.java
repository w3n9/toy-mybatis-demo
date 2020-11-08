package online.stringtek.toy.framework.toymybatisdemo;

import online.stringtek.toy.framework.toymybatis.factory.SqlSessionFactory;
import online.stringtek.toy.framework.toymybatis.factory.SqlSessionFactoryBuilder;
import online.stringtek.toy.framework.toymybatis.io.Resources;
import online.stringtek.toy.framework.toymybatis.pojo.SqlSession;
import online.stringtek.toy.framework.toymybatisdemo.mapper.UserMapper;
import online.stringtek.toy.framework.toymybatisdemo.pojo.User;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("online.stringtek.toy.framework.toymybatisdemo.mapper.UserMapper.selectList", User.class);
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("=================");
        User userParam=new User();
        userParam.setId(2);
        userParam.setUsername("tom");
//        userParam.setUsername("tom");
        User user = sqlSession.selectOne("online.stringtek.toy.framework.toymybatisdemo.mapper.UserMapper.selectOne", User.class,userParam);
        System.out.println(user);
        System.out.println("=================");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectList();
        for (User user1 : userList) {
            System.out.println(user1);
        }
        System.out.println("=================");
        System.out.println(userMapper.selectOne(userParam));
    }
}
