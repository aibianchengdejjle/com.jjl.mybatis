package com.jjl.Dao;
import com.jjl.pojo.Student;
import com.jjl.pojo.Teacher;
import com.jjl.utils.mybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;
public class Test1 {
    @Test
    public  void getteacher(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacher = mapper.getTeacher();
        for (Teacher t:teacher
             ) {
            System.out.println(t);
        }

        sqlSession.close();

    }
    @Test
    public  void getStudent(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();
        for (Student s:student
             ) {
            System.out.println(s);
        }

        sqlSession.close();

    }
}
