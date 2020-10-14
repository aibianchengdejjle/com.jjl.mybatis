package com.jjl.Dao;

import com.jjl.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

     public List<Student> getStudent();
}
