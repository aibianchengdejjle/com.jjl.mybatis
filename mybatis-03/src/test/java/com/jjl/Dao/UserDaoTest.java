package com.jjl.Dao;

import com.jjl.pojo.User;
import com.jjl.utils.mybatisUtils;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class); //UserDaoTest.class
    @Test
    public  void test(){
        SqlSession sqlSession=mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object>map=new HashMap<>();
        map.put("startIndex",0);
        map.put("pagesize",2);
        List<User> userBylimit = mapper.getUserBylimit(map);
        for (User u:userBylimit
             ) {
            System.out.println(u);
        }
        sqlSession.close();
    }
    @Test
    public  void testRowBounds(){
        SqlSession sqlSession=mybatisUtils.getSqlSession();

        RowBounds rowBounds=new RowBounds(1,2);
        List<Object> list = sqlSession.selectList("com.jjl.Dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (Object o:list
             ) {
            System.out.println(o);
        }

        sqlSession.close();
        }
    @Test
    public  void log4jtest(){
        logger.info("info:进度log4j的方法");
        logger.debug("debug方法");
        logger.error("进入error方法");
    }
    @Test
    public  void getUsers(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User u:users
             ) {
            System.out.println(u);
        }
        sqlSession.close();

    }
    @Test
    public  void delete(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.DeletUserByid(5);
        sqlSession.close();
    }
    @Test
    public  void add(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int swpu = mapper.add1(new User(5, "swpu", "654320"));
        System.out.println(swpu);
        sqlSession.close();
    }
    @Test
    public  void update(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.update(new User(5,"swpuno1","123456"));
        sqlSession.close();
    }
}
