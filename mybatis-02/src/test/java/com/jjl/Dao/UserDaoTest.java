package com.jjl.Dao;

import com.jjl.pojo.User;
import com.jjl.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;


public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class); //UserDao.class
    @Test
    public  void test(){
      SqlSession sqlSession =null;
      try {
          sqlSession=mybatisUtils.getSqlSession();
          UserMapper mapper = sqlSession.getMapper(UserMapper.class);
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
    public  void log4jtest(){
        logger.info("info:进度log4j的方法");
        logger.debug("debug方法");
        logger.error("进入error方法");
    }
}
