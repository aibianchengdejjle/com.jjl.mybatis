package com.jjl.Dao;

import com.jjl.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
   public List<Teacher> getTeacher();

}
