package com.jjl.Dao;

import com.jjl.pojo.User;
import com.jjl.utils.mybatisUtils;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public  void test(){
        SqlSession sqlSession = null;
        //方式二
       /* List<User> list = sqlSession.selectList("com.jjl.Dao.UserDao.getUserList");
        for (User user:list
             ) {
            System.out.println(user);
        }*/
       try {
           //获取连接对象
           sqlSession = mybatisUtils.getSqlSession();
           //方式一执行sql
           UserDao mapper = sqlSession.getMapper(UserDao.class);
           List<User> userList = mapper.getUserList();
           for (User u:userList
           ) {
               System.out.println(u);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           sqlSession.close();
       }
        
    }
    @Test
    public  void getUserByid(){
        SqlSession sqlSession=mybatisUtils.getSqlSession();
        //获得接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userByid = mapper.getUserByid(1);
        System.out.println(userByid);

        sqlSession.close();
    }
    @Test
    public  void addUser(){

        SqlSession sqlSession=mybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Integer integer = mapper.addUser(new User(4, "贾久乐", "123456"));
        //需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession=mybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.updateUser(new User(2,"ljj","654320"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void delete(){
        SqlSession sqlSession=mybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
       mapper.delete(2);
       sqlSession.commit();
       sqlSession.close();
    }
    @Test
    public  void addUser2(){
        SqlSession sqlSession=mybatisUtils.getSqlSession();
        HashMap<String,Object>map=new HashMap<>();
        map.put("userid",4);
        map.put("username","贾久乐");
        map.put("userpwd","a654320a");
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void selectlike(){
        SqlSession sqlSession=mybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> selectlike = mapper.selectlike("%李%");
        System.out.println(selectlike.size());
        for (User u: selectlike
             ) {
            System.out.println(u);
        }
        //因为是查询事务所以并不需要提交
        sqlSession.close();
    }
}
