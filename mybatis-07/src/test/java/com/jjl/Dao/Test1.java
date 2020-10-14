package com.jjl.Dao;

import com.jjl.pojo.Student;
import com.jjl.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test1 {
    @Test
    public  void getStudent(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();
        System.out.println(student);
        sqlSession.close();
    }

}
