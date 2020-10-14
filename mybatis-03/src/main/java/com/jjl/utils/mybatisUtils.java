package com.jjl.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class mybatisUtils {
    private  static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //读取配置文件
            String resource="mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
    public  static SqlSession getSqlSession(){
        return  sqlSessionFactory.openSession(true);
    }
}
